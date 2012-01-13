/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.generic.api;

import java.util.List;

/**
 *
 * @author khanguct
 */
public interface IGenericAPI {

    public boolean insertData(Object ob);

    public boolean deleteData(Class T, String id);

    public boolean updateData(Object ob);

    public List<Object> getAllData(Class T);

    public Object getByID(Class T, String id);

    public List<Object> filterByCondition(Class T, String field, String key);     
}
