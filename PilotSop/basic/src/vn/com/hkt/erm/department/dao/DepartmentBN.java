/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.erm.department.dao;

import vn.com.hkt.pilot.entities.Department;
import com.vn.hkt.generic.api.IGenericAPI;
import java.util.ArrayList;
import java.util.List;
import org.openide.util.Lookup;
import org.openide.util.lookup.ServiceProvider;
import vn.com.hkt.basic.api.IDepartmentBN;
import vn.com.hkt.pilot.entities.Enterprise;

/**
 *
 * @author duong
 */
@ServiceProvider(service = IDepartmentBN.class)
public class DepartmentBN implements IDepartmentBN {

    private IGenericAPI mydao;

    public DepartmentBN() {
        mydao = Lookup.getDefault().lookup(IGenericAPI.class);
    }

    @Override
    public boolean insertDepartment(Department department) {
        if (mydao.insertData(department)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean updateDepartment(Department department) {
        if (mydao.updateData(department)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteDepartment(Department department) {
        if (mydao.deleteData(Department.class, department.getDepartmentID())) {
            return true;
        }
        return false;
    }

    @Override
    public List<Department> getAllDepartment() {
        List<Department> list = new ArrayList<Department>();
        List<Object> obs = new ArrayList<Object>();
        obs = mydao.getAllData(Department.class);
        if (!obs.isEmpty()) {
            int i;
            for (i = 0; i < obs.size(); i++) {
                list.add((Department) obs.get(i));
            }
        }
        return list;
    }

    @Override
    public Department getDepartmentByID(String id) {
        return (Department)mydao.getByID(Department.class, id);
    }

    @Override
    public List<Department> filterDepartmentByID(String id) {
        List<Object> list = new ArrayList<Object>();
        List<Department> result = new ArrayList<Department>();
        list = mydao.filterByCondition(Department.class, "DepartmentID", id);
        if(!list.isEmpty()){
            int i;
            for(i=0;i<list.size();i++){
               result.add((Department)list.get(i));
            }
        }
        return result;
    }

    @Override
    public List<Department> filterDepartmentByName(String name) {
        List<Object> list= new ArrayList<Object>();
        List<Department> result = new ArrayList<Department>();
        list=mydao.filterByCondition(Department.class,"DepartmentName", name);
        if(!list.isEmpty()){
            int i;
            for(i=0;i<list.size();i++){
                result.add((Department)list.get(i));
            }
        }
        return result;
    }

    @Override
    public List<Department> filterDepartmentByEnterprise(Enterprise enterprise) {
        List<Object> list= new ArrayList<Object>();
        List<Department> result = new ArrayList<Department>();
        list=mydao.getAllData(Department.class);
        if(!list.isEmpty()){
            int i;
            for(i=0;i<list.size();i++){
                Department bean = (Department)list.get(i);
                if(enterprise.getEnterpriseID().equals(bean.getEnterpriseID()))
                result.add(bean);
            }
        }
        return result;
    }

    @Override
    public List<Enterprise> enterpriseHasDepartment() {
       
        String sql =  "SELECT enter  FROM Enterprise enter" 
               +" where enter.EnterpriseName IN (Select duan.EnterpriseID from Department duan)";
        List<Enterprise> list = new ArrayList<Enterprise>();
        List<Object> result = new ArrayList<Object>();
        result = mydao.filterByQuery(sql);
        if (!result.isEmpty()) {
            int i;
            for (i = 0; i < result.size(); i++) {
                list.add((Enterprise) result.get(i));
            }
        }
        return list;
    }

    @Override
    public List<Department> filterDepartmentByRootDepartment(Enterprise enterprise, Department department) {
        List<Department> list = new ArrayList<Department>();
        List<Department> list1 = new ArrayList<Department>();
        list1 = filterDepartmentByEnterprise(enterprise);
        if(!list1.isEmpty()){
            for(Department bean : list1){
                if(bean.getDepartmentParent().equals(department.getDepartmentName())){
                    list.add(bean);
                }
            }
        }
        return list;
    }
}
