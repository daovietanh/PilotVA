/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.basic.api;

import vn.com.hkt.pilot.entities.Operation;
import java.util.List;
import vn.com.hkt.pilot.entities.Department;
import vn.com.hkt.pilot.entities.Enterprise;
import vn.com.hkt.pilot.entities.Product;

/**
 *
 * @author khanguct
 */
public interface IOperationBN {

    public boolean insertOperation(Operation operation);

    public boolean updateOperation(Operation operation);

    public boolean deleteOperation(Operation operation);

    public List<Operation> getAllOperation();

    public Operation getOperationByID(String id);

    public List<Operation> filterOperationsByID(String id);

    public List<Operation> filterOperationsByName(String name);

    public List<Operation> filterOperationsBy_EnterpriseID(String name);

    /**
     * Lọc những Operation trong thời gian dạng Date(Ví dụ: dd/mm/yyyy)
     * @param date
     * @return 
     */
    public List<Operation> filterOperationByDate(String date);
    
     
    /**
     * Lấy ra danh sách các Operation theo mã Enterprise
     * @param enter
     * @return 
     */
    public List<Operation> getOperationByEnterprise(Enterprise enter);
    
    public List<Enterprise> enterpriseHasOperation();
    
    public List<String> weekHasOperation();
    
    public List<String> weekHasOperation(Enterprise enterprise);
    
    public List<Operation> getOperationByWeek(int week, int year);
    
    public List<Operation> getOperationByWeek(Enterprise enterprise, int week, int year);
    
    public List<Operation> filterOperationByDepartment(Enterprise enterprise, Department department);
    
    public List<Operation> filterOperationByProduct(Enterprise enterprise, Product product);
    
    public List<Operation> filterOperationByProduct(Enterprise enterprise, Department department, Product product);
}
