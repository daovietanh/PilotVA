/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.bom.operation.dao;

import vn.com.hkt.pilot.entities.Department;
import vn.com.hkt.pilot.entities.Operation;
import com.vn.hkt.generic.api.IGenericAPI;
import java.util.ArrayList;
import java.util.List;
import org.openide.util.Lookup;
import org.openide.util.lookup.ServiceProvider;
import vn.com.hkt.basic.api.IOperationBN;
import vn.com.hkt.pilot.datetime.utils.DateTimeConverter;
import vn.com.hkt.pilot.datetime.utils.DateTimeUtils;
import vn.com.hkt.pilot.entities.Enterprise;
import vn.com.hkt.pilot.entities.Product;

/**
 *
 * @author khanguct
 */
@ServiceProvider(service = IOperationBN.class)
public class OperationBN implements IOperationBN {
    
    private IGenericAPI mydao;
    private DateTimeUtils dateTimeUtils = new DateTimeUtils();
    private DateTimeConverter dateTimeConverter = new DateTimeConverter();    
    public OperationBN() {
        this.mydao = Lookup.getDefault().lookup(IGenericAPI.class);
    }
    
    @Override
    public boolean insertOperation(Operation operation) {
        if (mydao.insertData(operation)) {
            return true;
        }
        return false;
    }
    
    @Override
    public boolean updateOperation(Operation operation) {
        if (mydao.updateData(operation)) {
            return true;
        }
        return false;
    }
    
    @Override
    public boolean deleteOperation(Operation operation) {
        if (mydao.deleteData(Operation.class, operation.getOperationID())) {
            return true;
        }
        return false;
    }
    
    @Override
    public List<Operation> getAllOperation() {
        List<Operation> list = new ArrayList<Operation>();
        List<Object> obs = new ArrayList<Object>();
        obs = mydao.getAllData(Operation.class);
        if (!obs.isEmpty()) {
            int i;
            for (i = 0; i < obs.size(); i++) {
                list.add((Operation) obs.get(i));                
            }
        }
        return list;
    }
    
    @Override
    public Operation getOperationByID(String id) {
        return (Operation) mydao.getByID(Operation.class, id);
    }
    
    @Override
    public List<Operation> filterOperationByDate(String date) {
        List<Operation> list = new ArrayList<Operation>();
        List<Object> result = new ArrayList<Object>();
        result = mydao.filterByCondition(Operation.class, "DateTime", date);
        if (!result.isEmpty()) {
            int i;
            for (i = 0; i < result.size(); i++) {
                list.add((Operation) result.get(i));
            }
        }
        return list;
    }
    
    @Override
    public List<Operation> filterOperationsByID(String id) {
        List<Operation> list = new ArrayList<Operation>();
        List<Object> result = new ArrayList<Object>();
        result = mydao.filterByCondition(Operation.class, "OperationID", id);
        if (!result.isEmpty()) {
            int i;
            for (i = 0; i < result.size(); i++) {
                list.add((Operation) result.get(i));
            }
        }
        return list;
    }
    
    @Override
    public List<Operation> filterOperationsByName(String name) {
        List<Operation> list = new ArrayList<Operation>();
        List<Object> result = new ArrayList<Object>();
        result = mydao.filterByCondition(Operation.class, "OperationName", name);
        if (!result.isEmpty()) {
            int i;
            for (i = 0; i < result.size(); i++) {
                list.add((Operation) result.get(i));
            }
        }
        return list;
    }
    
    @Override
    public List<Operation> filterOperationsBy_EnterpriseID(String name) {
        List<Operation> list = new ArrayList<Operation>();
        List<Object> result = new ArrayList<Object>();
        result = mydao.filterByCondition(Operation.class, "EnterpriseID", name);
        if (!result.isEmpty()) {
            int i;
            for (i = 0; i < result.size(); i++) {
                list.add((Operation) result.get(i));
            }
        }
        return list;
    }
    
    @Override
    public List<Operation> getOperationByEnterprise(Enterprise enter) {
        List<Operation> list = new ArrayList<Operation>();
        List<Operation> list1 = mydao.getAllData(Operation.class);
        if(!list1.isEmpty()){
            for(Operation bean : list1){
                if(bean.getEnterpriseID().equals(enter.getEnterpriseName())){
                    list.add(bean);
                }
            }
        }
        return list;
    }

    @Override
    public List<Enterprise> enterpriseHasOperation() {
        String sql = "SELECT enter  FROM Enterprise enter "
                + "where enter.EnterpriseName IN (Select oper.EnterpriseID from Operation oper)";
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
    public List<String> weekHasOperation() {
        int i = 0;
        List<String> list = new ArrayList<String>();
        List<Operation> list1 = new ArrayList<Operation>();
        list1 = mydao.getAllData(Operation.class);
        if(!list1.isEmpty()){
            for(Operation bean : list1){
                i = dateTimeConverter.getWeekOfYear(bean.getDateTime());
                list.add(String.valueOf(i));
            }
        }
        return list;
    }

    @Override
    public List<String> weekHasOperation(Enterprise enterprise) {
        int i = 0;
        List<String> list = new ArrayList<String>();
        List<Operation> list1 = new ArrayList<Operation>();
        list1 = getOperationByEnterprise(enterprise);
        if(!list1.isEmpty()){
            for(Operation bean : list1){
                i = dateTimeConverter.getWeekOfYear(bean.getDateTime());
                list.add(String.valueOf(i));
            }
        }
        return list;
    }

    @Override
    public List<Operation> getOperationByWeek(int week, int year) {
        List<Operation> list = new ArrayList<Operation>();
        list = getAllOperation();
        if(!list.isEmpty()){
            for(Operation bean : list){
                int w = dateTimeConverter.getWeekOfMonth(bean.getDateTime());
                int y = dateTimeConverter.getYear(bean.getDateTime());
                if((week==w) && (year==y)){
                    list.add(bean);
                }
            }
        }
        return list;
    }

    @Override
    public List<Operation> getOperationByWeek(Enterprise enterprise, int week, int year) {
        List<Operation> list = new ArrayList<Operation>();
        list = getOperationByEnterprise(enterprise);
        if(!list.isEmpty()){
            for(Operation bean : list){
                int w = dateTimeConverter.getWeekOfMonth(bean.getDateTime());
                int y = dateTimeConverter.getYear(bean.getDateTime());
                if((week==w) && (year==y)){
                    list.add(bean);
                }
            }
        }
        return list;
    }

    @Override
    public List<Operation> filterOperationByDepartment(Enterprise enterprise, Department department) {
        List<Operation> list = new ArrayList<Operation>();
        List<Operation> list1 = new ArrayList<Operation>();
        list1 = mydao.getAllData(Operation.class);
        if(!list1.isEmpty()){
            for(Operation bean : list1){
                if(bean.getEnterpriseID().equals(enterprise.getEnterpriseName()) && 
                        bean.getDepartmentID().equals(department.getDepartmentName())){
                    list.add(bean);
                }
            }
        }
        return list;
    }

    @Override
    public List<Operation> filterOperationByProduct(Enterprise enterprise, Product product) {
        List<Operation> list = new ArrayList<Operation>();
        List<Operation> list1 = new ArrayList<Operation>();
        list1 = getOperationByEnterprise(enterprise);
        if(!list1.isEmpty()){
            for(Operation operation:list1){
                if(operation.getProductID().equals(product.getProductName())){
                    list.add(operation);
                }
            }
        }
        return list;
    }

    @Override
    public List<Operation> filterOperationByProduct(Enterprise enterprise, Department department, Product product) {
        List<Operation> list = new ArrayList<Operation>();
        List<Operation> list1 = new ArrayList<Operation>();
        list1 = filterOperationByProduct(enterprise, product);
        if(!list1.isEmpty()){
            for(Operation operation:list1){
                if(operation.getDepartmentID().equals(department.getDepartmentName())){
                    list.add(operation);
                }
            }
        }
        return list;
    }
    
    
}
