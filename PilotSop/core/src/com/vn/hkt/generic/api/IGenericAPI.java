/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.hkt.generic.api;

import java.util.List;
//Upgrade: bổ sung generic<T>

/**
 *
 * @author khanguct
 */
public interface IGenericAPI<E> {

    public boolean insertData(E ob);

    public boolean deleteData(Class T, String id);

    public boolean removeData(Class T, int id);

    public boolean updateData(E ob);

    public List<E> getAllData(Class T);

    public E getByID(Class T, String id);

    public E getByID(Class T, int id);

    public E getByName(Class T, String name);

    public List<E> filterByCondition(Class T, String field, String key);

    public List<E> filterByQuery(String sql);

    public boolean doLogin(String username, String password);
}
