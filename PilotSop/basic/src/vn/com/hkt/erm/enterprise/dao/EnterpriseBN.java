/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.erm.enterprise.dao;

import vn.com.hkt.pilot.entities.Enterprise;
import com.vn.hkt.generic.api.IGenericAPI;
import java.util.ArrayList;
import java.util.List;
import org.openide.util.Lookup;
import org.openide.util.lookup.ServiceProvider;
import vn.com.hkt.basic.api.IEnterpriseBN;

/**
 *
 * @author khangphamngoc
 */
@ServiceProvider(service=IEnterpriseBN.class)
public class EnterpriseBN implements IEnterpriseBN {

    private IGenericAPI mydao;

    public EnterpriseBN() {
        
        mydao = Lookup.getDefault().lookup(IGenericAPI.class);
       
    }
    
    

    @Override
    public boolean insertEnterprise(Enterprise enterprise) {
        if (mydao.insertData(enterprise)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean updateEnterprise(Enterprise enterprise) {
        if (mydao.updateData(enterprise)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteEnterprise(Enterprise enterprise) {
        if (mydao.deleteData(Enterprise.class, enterprise.getEnterpriseID())) {
            return true;
        }
        return false;

    }

    @Override
    public List<Enterprise> getAllEnterprise() {
        List<Enterprise> list = new ArrayList<Enterprise>();
        List<Object> obs = new ArrayList<Object>();
        obs = mydao.getAllData(Enterprise.class);
        if(!obs.isEmpty()){
            int i;
            for(i=0;i<obs.size();i++){
                 list.add( (Enterprise)obs.get(i));                              
            }
        }
        return list;
    }

    @Override //Lay 1 row theo ID
    public Enterprise getEnterpriseByID(String id) {
        return (Enterprise)mydao.getByID(Enterprise.class, id);
    }

    @Override
    public List<Enterprise> filterEnterpriseByID(String id) {
        List<Object> list = new ArrayList<Object>();
        List<Enterprise> result = new ArrayList<Enterprise>();
        list = mydao.filterByCondition(Enterprise.class, "EnterpriseID", id);
        if(!list.isEmpty()){
            int i;
            for(i=0;i<list.size();i++){
               result.add((Enterprise)list.get(i));
            }
        }
        return result;
    }

    @Override
    public List<Enterprise> filterEnterpriseByName(String name) {
         List<Object> list = new ArrayList<Object>();
        List<Enterprise> result = new ArrayList<Enterprise>();
        list = mydao.filterByCondition(Enterprise.class, "EnterpriseName", name);
        if(!list.isEmpty()){
            int i;
            for(i=0;i<list.size();i++){
               result.add((Enterprise)list.get(i));
            }
        }
        return result;
    }

    @Override
    public List<Enterprise> filterEnterpriseByChild(Enterprise enterprise) {
        List<Enterprise> list = new ArrayList<Enterprise>();
        List<Enterprise> list1 = new ArrayList<Enterprise>();
        list1 = mydao.getAllData(Enterprise.class);
        if(!list1.isEmpty()){
            for(Enterprise bean : list1){
                if(bean.getEnterpriseParent().equals(enterprise.getEnterpriseName())){
                    list.add(bean);
                }
            }
        }
        return list;
    }
}
