package com.cmvb.gradash.serviciosImpl;

import com.cmvb.gradash.entidades.TbUsuario;
import com.cmvb.gradash.enumerados.ESiNo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.cmvb.gradash.servicios.IUsuariosServicio;

import java.io.Serializable;
import java.util.List;
import java.util.Map.Entry;
import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
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

            sql.append(" SELECT t FROM ");
            sql.append(TbUsuario.class.getCanonicalName()).append(" t ");
            sql.append(" WHERE 1 = 1 ");

            sql.append(" AND t.estado = :estadoActivo ");
            map.put("estadoActivo", ESiNo.SI.getId());

            sql.append("ORDER BY t.usuario ");

            Query query = em.createQuery(sql.toString());
            for (Entry<String, Object> valor : map.entrySet()) {
                query.setParameter(valor.getKey(), valor.getValue());
            }

            List<TbUsuario> listaTmp = query.getResultList();
            if (listaTmp != null && !listaTmp.isEmpty()) {
                for (TbUsuario user : listaTmp) {
                    result.add(user);
                }
            }

            em.close();

            return result;
        } catch (Exception e) {
            LOG.error(e.getMessage());
            throw new Exception(e);
        }
    }

}
