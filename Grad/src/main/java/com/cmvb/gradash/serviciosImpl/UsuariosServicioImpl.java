package com.cmvb.gradash.serviciosImpl;

import com.cmvb.gradash.entidades.TbUsuario;
import com.cmvb.gradash.enumerados.ECriterioBusqueda;
import com.cmvb.gradash.enumerados.EEstadoRespuestaHTTP;
import com.cmvb.gradash.enumerados.ESiNo;
import com.cmvb.gradash.responses.BaseResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.cmvb.gradash.servicios.IUsuariosServicio;
import com.cmvb.gradash.util.Util;

import java.io.Serializable;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

/**
 *
 * @author veracm
 */
@Service
public class UsuariosServicioImpl implements IUsuariosServicio, Serializable {

    private static final long serialVersionUID = -372677706122965556L;
    private static final String PERSISTENCE_UNIT_NAME = "com.cmvb.Gradients.war.1.0";
    private static final Logger LOG = LoggerFactory.getLogger(UsuariosServicioImpl.class);

    @PostConstruct
    public void init() {
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }

    @Autowired
    private static final BaseServicioImpl baseSB = new BaseServicioImpl();

    @Override
    public List<TbUsuario> findAllUsuarios() throws Exception {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
            EntityManager em = emf.createEntityManager();

            FastTable<TbUsuario> result = new FastTable<>();
            FastMap<String, Object> map = new FastMap<>();

            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT COUNT(t) FROM ");
            sql.append(TbUsuario.class.getCanonicalName()).append(" t ");
            sql.append(" WHERE 1 = 1 ");

            sql.append(" AND t.estado = :estadoActivo ");
            map.put("estadoActivo", ESiNo.SI.getId());

            Query query = em.createQuery(sql.toString());
            for (Entry<String, Object> valor : map.entrySet()) {
                query.setParameter(valor.getKey(), valor.getValue());
            }

            List count = query.getResultList();
            Long rows = (Long) count.get(0);
            Long rowsRead = 0l;

            while (rowsRead < rows) {
                FastTable<TbUsuario> internalResult = new FastTable<>();
                map = new FastMap<>();
                sql = new StringBuilder();
                sql.append(" SELECT t FROM ");
                sql.append(TbUsuario.class.getCanonicalName()).append(" t ");
                sql.append(" WHERE 1 = 1 ");

                sql.append(" AND t.estado = :estadoActivo ");
                map.put("estadoActivo", ESiNo.SI.getId());

//                sql.append("ORDER BY t ");
                sql.append("LIMIT 900 OFFSET ");
                sql.append(rowsRead);
//                sql.append(" ROWS ");
//                sql.append("FETCH NEXT 900 ROW ONLY ");

                query = em.createQuery(sql.toString());
                for (Entry<String, Object> valor : map.entrySet()) {
                    query.setParameter(valor.getKey(), valor.getValue());
                }

                List<TbUsuario> listaTmp = query.getResultList();
                if (listaTmp != null && !listaTmp.isEmpty()) {
                    for (TbUsuario user : listaTmp) {
                        internalResult.add(user);
                    }

                    rowsRead = rowsRead + internalResult.size();
                    rows = rows - rowsRead;
                    result.addAll(internalResult);
                }
            }
            em.close();

            return result;
        } catch (NumberFormatException ex) {
            LOG.error("|>>>>>>>> ERROR: " + new Date() + " - " + ex.getMessage(), ex);
            throw new Exception(ex);
        }
    }

    @Override
    public List<TbUsuario> getUsuarios(TbUsuario usuario) throws Exception {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
            EntityManager em = emf.createEntityManager();

            FastTable<TbUsuario> result = new FastTable<>();
            FastMap<String, Object> map = new FastMap<>();

            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT COUNT(t) FROM ");
            sql.append(TbUsuario.class.getCanonicalName()).append(" t ");
            sql.append(" WHERE 1 = 1 ");

            sql.append(" AND t.estado = :estadoActivo ");
            map.put("estadoActivo", ESiNo.SI.getId());

            if (!Util.esVacio(usuario.getUsuario())) {
                sql.append(" AND t.usuario = :usuario ");
                map.put("usuario", usuario.getUsuario());
            }

            if (!Util.esVacio(usuario.getPrimerNombre())) {
                sql.append(" AND t.primerNombre LIKE :primerNombre ");
                map.put("primerNombre", Util.incluirCriterio(usuario.getPrimerNombre(), ECriterioBusqueda.ANYWHERE));
            }

            if (!Util.esVacio(usuario.getSegundoNombre())) {
                sql.append(" AND t.segundoNombre LIKE :segundoNombre ");
                map.put("segundoNombre", Util.incluirCriterio(usuario.getSegundoNombre(), ECriterioBusqueda.ANYWHERE));
            }

            if (!Util.esVacio(usuario.getPrimerApellido())) {
                sql.append(" AND t.primerApellido LIKE :primerApellido ");
                map.put("primerApellido", Util.incluirCriterio(usuario.getPrimerApellido(), ECriterioBusqueda.ANYWHERE));
            }

            if (!Util.esVacio(usuario.getSegundoApellido())) {
                sql.append(" AND t.segundoApellido LIKE :segundoApellido ");
                map.put("segundoApellido", Util.incluirCriterio(usuario.getSegundoApellido(), ECriterioBusqueda.ANYWHERE));
            }

            if (usuario.getSexo() > 0) {
                sql.append(" AND t.sexo = :sexo ");
                map.put("sexo", usuario.getSexo());
            }

            if (usuario.getTipoDocumento() > 0) {
                sql.append(" AND t.tipoDocumento = :tipoDocumento ");
                map.put("tipoDocumento", usuario.getTipoDocumento());
            }

            if (!Util.esVacio(usuario.getNumeroDocumento())) {
                sql.append(" AND t.numeroDocumento = :numeroDocumento ");
                map.put("numeroDocumento", usuario.getNumeroDocumento());
            }

            Query query = em.createQuery(sql.toString());
            for (Entry<String, Object> valor : map.entrySet()) {
                query.setParameter(valor.getKey(), valor.getValue());
            }

            List count = query.getResultList();
            Long rows = (Long) count.get(0);
            Long rowsRead = 0l;

            while (rowsRead < rows) {
                FastTable<TbUsuario> internalResult = new FastTable<>();
                map = new FastMap<>();
                sql = new StringBuilder();

                sql.append(" SELECT t FROM ");
                sql.append(TbUsuario.class.getCanonicalName()).append(" t ");
                sql.append(" WHERE 1 = 1 ");

                sql.append(" AND t.estado = :estadoActivo ");
                map.put("estadoActivo", ESiNo.SI.getId());

                if (!Util.esVacio(usuario.getUsuario())) {
                    sql.append(" AND t.usuario = :usuario ");
                    map.put("usuario", usuario.getUsuario());
                }

                if (!Util.esVacio(usuario.getPrimerNombre())) {
                    sql.append(" AND t.primerNombre LIKE :primerNombre ");
                    map.put("primerNombre", Util.incluirCriterio(usuario.getPrimerNombre(), ECriterioBusqueda.ANYWHERE));
                }

                if (!Util.esVacio(usuario.getSegundoNombre())) {
                    sql.append(" AND t.segundoNombre LIKE :segundoNombre ");
                    map.put("segundoNombre", Util.incluirCriterio(usuario.getSegundoNombre(), ECriterioBusqueda.ANYWHERE));
                }

                if (!Util.esVacio(usuario.getPrimerApellido())) {
                    sql.append(" AND t.primerApellido LIKE :primerApellido ");
                    map.put("primerApellido", Util.incluirCriterio(usuario.getPrimerApellido(), ECriterioBusqueda.ANYWHERE));
                }

                if (!Util.esVacio(usuario.getSegundoApellido())) {
                    sql.append(" AND t.segundoApellido LIKE :segundoApellido ");
                    map.put("segundoApellido", Util.incluirCriterio(usuario.getSegundoApellido(), ECriterioBusqueda.ANYWHERE));
                }

                if (usuario.getSexo() > 0) {
                    sql.append(" AND t.sexo = :sexo ");
                    map.put("sexo", usuario.getSexo());
                }

                if (usuario.getTipoDocumento() > 0) {
                    sql.append(" AND t.tipoDocumento = :tipoDocumento ");
                    map.put("tipoDocumento", usuario.getTipoDocumento());
                }

                if (!Util.esVacio(usuario.getNumeroDocumento())) {
                    sql.append(" AND t.numeroDocumento = :numeroDocumento ");
                    map.put("numeroDocumento", usuario.getNumeroDocumento());
                }

                sql.append("ORDER BY t.idUsuario ");
                sql.append("OFFSET ");
                sql.append(rowsRead);
                sql.append(" ROWS ");
                sql.append("FETCH NEXT 900 ROW ONLY ");

                query = em.createQuery(sql.toString());
                for (Entry<String, Object> valor : map.entrySet()) {
                    query.setParameter(valor.getKey(), valor.getValue());
                }

                List<TbUsuario> listaTmp = query.getResultList();
                if (listaTmp != null && !listaTmp.isEmpty()) {
                    for (TbUsuario user : listaTmp) {
                        internalResult.add(user);
                    }

                    rowsRead = rowsRead + internalResult.size();
                    rows = rows - rowsRead;
                    result.addAll(internalResult);
                }
            }
            em.close();

            return result;
        } catch (NumberFormatException ex) {
            LOG.error("|>>>>>>>> ERROR: " + new Date() + " - " + ex.getMessage(), ex);
            throw new Exception(ex);
        }
    }

    @Override
    public BaseResponse saveUpdateUsuario(TbUsuario usuario) throws Exception {
        BaseResponse result = new BaseResponse();
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
            EntityManager em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();

            if (usuario.getIdUsuario() != 0) {
                em.merge(usuario);
            } else {
                em.persist(usuario);
            }

            tx.commit();
            em.close();

            result.setCodigo(EEstadoRespuestaHTTP.ACEPTADO.getId());
            result.setDescripcion(EEstadoRespuestaHTTP.ACEPTADO.getMessage(Util.LOCALIDAD));
            result.setValor(true);
        } catch (Exception ex) {
            LOG.error("|>>>>>>>> ERROR: " + new Date() + " - " + ex.getMessage(), ex);
            throw new Exception(ex);
        }

        return result;
    }

    @Override
    public BaseResponse deleteUsuario(TbUsuario usuario) throws Exception {
        BaseResponse result = new BaseResponse();
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
            EntityManager em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            em.remove(usuario);

            tx.commit();
            em.close();

            result.setCodigo(EEstadoRespuestaHTTP.ACEPTADO.getId());
            result.setDescripcion(EEstadoRespuestaHTTP.ACEPTADO.getMessage(Util.LOCALIDAD));
            result.setValor(true);
        } catch (Exception ex) {
            LOG.error("|>>>>>>>> ERROR: " + new Date() + " - " + ex.getMessage(), ex);
            throw new Exception(ex);
        }

        return result;
    }
}
