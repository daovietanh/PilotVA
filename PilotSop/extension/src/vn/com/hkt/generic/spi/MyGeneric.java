/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.generic.spi;

import vn.com.hkt.generic.api.IGenericAPI;
import vn.com.hkt.generic.jpas.utils.jpaUtils;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import org.openide.util.lookup.ServiceProvider;

/**
 *
 * @author khanguct
 */
@ServiceProvider(service = IGenericAPI.class)
public class MyGeneric implements IGenericAPI {

    private EntityManager em;
    private jpaUtils jpu = new jpaUtils();

    public MyGeneric() {
    }

    @Override
    public boolean insertData(Object ob) {
        em = jpu.getEm();
        em.getTransaction().begin();
        try {
            em.persist(ob);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            em.close();
        }
    }

    @Override
    public boolean deleteData(Class T, String id) {
        em = jpu.getEm();
        em.getTransaction().begin();
        try {
            Object ob = em.find(T, id);
            em.remove(ob);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            em.close();
        }
    }

    @Override
    public boolean updateData(Object ob) {
        em = jpu.getEm();
        em.getTransaction().begin();
        try {
            em.merge(ob);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            em.close();
        }
    }

    @Override
    public Object getByID(Class T, String id) {
        Object object = null;
        em = jpu.getEm();
        em.getTransaction().begin();
        try {
            object = em.find(T, id);
        } catch (Exception e) {
        } finally {
            em.close();
        }
        return object;
    }

    @Override
    public List<Object> getAllData(Class T) {
        List<Object> list = new ArrayList<Object>();
        em = jpu.getEm();
        try {
            list = em.createQuery("Select ob from " + T.getSimpleName() + " ob").getResultList();
        } catch (Exception ex) {
        } finally {
            em.close();
        }
        return list;
    }

    @Override
    public List<Object> filterByCondition(Class T, String field, String name) {
        List<Object> list = new ArrayList<Object>();
        String serchWord = "%" + name.toLowerCase() + "%";
        String sql = "Select tbl from " + T.getSimpleName() + " tbl where lower(tbl." + field
                + ") like '" + serchWord + "'";
        em = jpu.getEm();
        try {
            list = em.createQuery(sql).getResultList();
        } catch (Exception ex) {
        } finally {
            em.close();
        }
        return list;
    }
}
