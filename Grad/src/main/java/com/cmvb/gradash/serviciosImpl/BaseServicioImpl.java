package com.cmvb.gradash.serviciosImpl;

import com.cmvb.gradash.entidades.TbConsecutivo;
import com.cmvb.gradash.servicios.IBaseServicio;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
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
import org.springframework.stereotype.Service;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

/**
 *
 * @author veracm
 */
@Service
public class BaseServicioImpl implements IBaseServicio, Serializable {

    private static final Logger LOG = LoggerFactory.getLogger(BaseServicioImpl.class);
    private static final String PERSISTENCE_UNIT_NAME = "com.cmvb.Gradients.war.1.0";
    private static final long serialVersionUID = -2162031172291716121L;

    @PostConstruct
    public void init() {
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }

    @Override
    public long autoID(String nombreTabla) throws Exception {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
            EntityManager em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();

            FastTable<TbConsecutivo> result = new FastTable<>();
            long id = 0;
            FastMap<String, Object> map = new FastMap<>();

            StringBuilder sql = new StringBuilder();

            sql.append(" SELECT t FROM ");
            sql.append(TbConsecutivo.class.getCanonicalName()).append(" t ");
            sql.append(" WHERE 1 = 1 ");

            sql.append(" AND t.tabla = :tabla ");
            map.put("tabla", nombreTabla);

            sql.append("ORDER BY t.tabla ");

            Query query = em.createQuery(sql.toString());
            for (Entry<String, Object> valor : map.entrySet()) {
                query.setParameter(valor.getKey(), valor.getValue());
            }

            List<TbConsecutivo> listaTmp = query.getResultList();
            if (listaTmp != null && !listaTmp.isEmpty()) {
                for (TbConsecutivo consecutivo : listaTmp) {
                    consecutivo.setSecuencia(consecutivo.getSecuencia() + 1);
                    result.add(consecutivo);
                    break;
                }

                id = result.getFirst().getSecuencia();
                em.merge(result.getFirst());
                tx.commit();
            }

            em.close();

            return id;
        } catch (Exception e) {
            LOG.error(e.getMessage());
            throw new Exception(e);
        }
    }

}
