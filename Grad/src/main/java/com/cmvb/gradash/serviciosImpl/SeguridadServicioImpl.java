package com.cmvb.gradash.serviciosImpl;

import com.cmvb.gradash.dto.TbUsuarioDto;
import com.cmvb.gradash.entidades.TbSesion;
import com.cmvb.gradash.entidades.TbUsuario;
import com.cmvb.gradash.enumerados.EEstado;
import com.cmvb.gradash.enumerados.ESiNo;
import com.cmvb.gradash.servicios.ISeguridadServicio;
import com.cmvb.gradash.util.Mensaje;
import com.cmvb.gradash.util.NextValues;
import com.cmvb.gradash.util.Util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;
import java.util.Map.Entry;
import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javolution.util.FastMap;
import javolution.util.FastTable;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

/**
 *
 * @author veracm
 */
@Service
public class SeguridadServicioImpl implements ISeguridadServicio, Serializable {

    private static final long serialVersionUID = 2946490233173130843L;
    private static final String PERSISTENCE_UNIT_NAME = "com.cmvb.Gradients.war.1.0";
    private static final Logger LOG = LoggerFactory.getLogger(SeguridadServicioImpl.class);

    @PostConstruct
    public void init() {
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }

    @Autowired
    private static final BaseServicioImpl baseSB = new BaseServicioImpl();

    @Override
    public TbUsuarioDto login(String usuario, String clave) throws Exception {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
            EntityManager em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();

            FastTable<TbUsuario> result = new FastTable<>();
            FastMap<String, Object> map = new FastMap<>();

            StringBuilder sql = new StringBuilder();

            sql.append(" SELECT t FROM ");
            sql.append(TbUsuario.class.getCanonicalName()).append(" t ");
            sql.append(" WHERE 1 = 1 ");

            sql.append(" AND t.usuario = :usuario ");
            map.put("usuario", usuario);

            sql.append(" AND t.clave = :clave ");
            map.put("clave", (Util.getEncriptado(clave, true)).substring(0, 20));

            sql.append(" AND t.estado = :estadoActivo ");
            map.put("estadoActivo", ESiNo.SI.getId());

            sql.append("ORDER BY t.usuario ");

            Query query = em.createQuery(sql.toString());
            for (Entry<String, Object> valor : map.entrySet()) {
                query.setParameter(valor.getKey(), valor.getValue());
            }

            TbUsuarioDto dto = new TbUsuarioDto();
            List<TbUsuario> listaTmp = query.getResultList();
            String mensajeError = "";
            if (listaTmp != null && !listaTmp.isEmpty()) {
                Date ahora = new Date();
                for (TbUsuario user : listaTmp) {
                    result.add(user);
                    break;
                }

                BeanUtils.copyProperties(dto, result.getFirst());

                // Inactivamos las otras sesiones
                sql = new StringBuilder();
                sql.append("UPDATE ");
                sql.append(TbSesion.class.getCanonicalName());
                sql.append(" t SET t.activo = :estado ");
                sql.append(" WHERE t.usuario = :usuario ");
                query = em.createQuery(sql.toString());
                query.setParameter("estado", ESiNo.NO.getId());
                query.setParameter("usuario", dto.getUsuario());
                query.executeUpdate();

                // Damos alta a la sesion actual
                TbSesion sesion = new TbSesion();
                sesion.setIdSesion(baseSB.autoID(NextValues.TB_SESION));
                String llaveSesion = dto.getUsuario() + dto.getClave() + new Date();
                sesion.setTokenSesion(Util.getEncriptado(llaveSesion, true).substring(0, 50));
                sesion.setActivo(ESiNo.SI.getId());
                sesion.setUsuario(dto.getUsuario());
                sesion.setUsuarioCreacion(dto.getUsuario());
                sesion.setFechaCreacion(ahora);
                sesion.setUsuarioActualiza(dto.getUsuario());
                sesion.setFechaActualiza(ahora);
                sesion.setEstado(EEstado.ACTIVO.getId());
                em.persist(sesion);
                tx.commit();

                dto.setTokenSesion(sesion.getTokenSesion());
                dto.setTbSesion(sesion);
                LOG.info("|>>>>>>>> INICIO SESIÓN: " + new Date() + " - " + dto.getUsuario());

                em.close();
            } else {
                mensajeError = Mensaje.getMensaje(Util.LOCALIDAD, "lbl_err_no_pudo_iniciar_sesion");
                dto.setMensajeErrorSesion(mensajeError);
                LOG.warn("|>>>>>>>> WARNING: " + new Date() + " - " + mensajeError);
            }

            return dto;
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException ex) {
            LOG.error("|>>>>>>>> ERROR: " + new Date() + " - " + ex.getMessage(), ex);
            throw new Exception(ex);
        }
    }

    @Override
    public TbSesion obtenerSesion(String usuario, String token) throws Exception {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
            EntityManager em = emf.createEntityManager();

            FastTable<TbSesion> result = new FastTable<>();
            FastMap<String, Object> map = new FastMap<>();

            StringBuilder sql = new StringBuilder();

            sql.append(" SELECT t FROM ");
            sql.append(TbSesion.class.getCanonicalName()).append(" t ");
            sql.append(" WHERE 1 = 1 ");

            sql.append(" AND t.usuario = :usuario ");
            map.put("usuario", usuario);

            sql.append(" AND t.tokenSesion = :tokenSesion ");
            map.put("tokenSesion", token);

            sql.append("ORDER BY t.fechaActualiza DESC ");

            Query query = em.createQuery(sql.toString());
            for (Entry<String, Object> valor : map.entrySet()) {
                query.setParameter(valor.getKey(), valor.getValue());
            }

            List<TbSesion> listaTmp = query.getResultList();
            if (listaTmp != null && !listaTmp.isEmpty()) {
                for (TbSesion sesion : listaTmp) {
                    result.add(sesion);
                }
            }

            em.close();

            return result.getFirst();
        } catch (Exception e) {
            LOG.error(e.getMessage());
            throw new Exception(e);
        }
    }

    @Override
    public boolean cerrarSesion(TbSesion sesion, String usuario) throws Exception {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
            EntityManager em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();

            Date ahora = new Date();
            sesion.setActivo(ESiNo.NO.getId());
            sesion.setFechaCreacion(ahora);
            sesion.setUsuarioActualiza(usuario);
            sesion.setFechaActualiza(ahora);
            sesion.setEstado(EEstado.INACTIVO.getId());
            em.merge(sesion);

            tx.commit();
            em.close();

            return true;
        } catch (Exception e) {
            LOG.error(e.getMessage());
            throw new Exception(e);
        }
    }

}
