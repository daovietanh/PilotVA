/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.enterprise.ext.dao;

import java.util.ArrayList;
import java.util.List;
import org.openide.util.Lookup;
import vn.com.hkt.enterprise.ext.entity.EnterpriseExt;
import vn.com.hkt.generic.api.IGenericAPI;

/**
 *
 * @author khanguct
 */
public class EnterpriseExtBN {

    private IGenericAPI mydao;

    public EnterpriseExtBN() {

        mydao = Lookup.getDefault().lookup(IGenericAPI.class);

    }

    public boolean insertEnterpriseExt(EnterpriseExt enex) {
        if (mydao.insertData(enex)) {
            return true;
        }
        return false;
    }

    public boolean updateEnterpriseExt(EnterpriseExt enex) {
        if (mydao.updateData(enex)) {
            return true;
        }
        return false;
    }

    public boolean deleteEnterpriseExt(EnterpriseExt enex) {
        if (mydao.deleteData(EnterpriseExt.class, enex.getEnterpriseID())) {
            return true;
        }
        return false;
    }

    public List<EnterpriseExt> getAllEnterpriseExt() {
        List<EnterpriseExt> list = new ArrayList<EnterpriseExt>();
        List<Object> obs = new ArrayList<Object>();
        obs = mydao.getAllData(EnterpriseExt.class);
        if (!obs.isEmpty()) {
            int i;
            for (i = 0; i < obs.size(); i++) {
                list.add((EnterpriseExt) obs.get(i));
            }
        }
        return list;
    }

    public EnterpriseExt getEnterpriseExtByID(String id) {
        return (EnterpriseExt) mydao.getByID(EnterpriseExt.class, id);
    }

    public List<EnterpriseExt> filterEnterpriseExtByID(String id) {
        List<Object> list = new ArrayList<Object>();
        List<EnterpriseExt> result = new ArrayList<EnterpriseExt>();
        list = mydao.filterByCondition(EnterpriseExt.class, "EnterpriseID", id);
        if (!list.isEmpty()) {
            int i;
            for (i = 0; i < list.size(); i++) {
                result.add((EnterpriseExt) list.get(i));
            }
        }
        return result;
    }

    public List<EnterpriseExt> filterEnterpriseExtByName(String name) {
        List<Object> list = new ArrayList<Object>();
        List<EnterpriseExt> result = new ArrayList<EnterpriseExt>();
        list = mydao.filterByCondition(EnterpriseExt.class, "EnterpriseName", name);
        if (!list.isEmpty()) {
            int i;
            for (i = 0; i < list.size(); i++) {
                result.add((EnterpriseExt) list.get(i));
            }
        }
        return result;
    }
}
