/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.hkt.generic.spi;

import com.vn.hkt.core.Account;
import com.vn.hkt.generic.api.IGenericAPI;
import com.vn.hkt.generic.jpas.utils.jpaUtils;
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
    public Object getByName(Class T, String name) {
        Object object = null;
        em = jpu.getEm();
        em.getTransaction().begin();
        try {
            object = em.find(T, name);
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

    @Override
    public boolean doLogin(String username, String password) {
        em = jpu.getEm();
        em.getTransaction().begin();
        try {
            Account obj = em.find(Account.class, username);
            if (obj != null) {
                if (obj.getPassword().equals(password)) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            em.close();
        }
    }

    @Override
    public boolean removeData(Class T, int id) {
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
    public Object getByID(Class T, int id) {
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
    public List<Object> filterByQuery(String sql) {
        List<Object> list = new ArrayList<Object>();
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
