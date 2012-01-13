/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.finance.api;

import vn.com.hkt.pilot.entities.Product;
import vn.com.hkt.pilot.entities.Department;
import vn.com.hkt.pilot.entities.Enterprise;
import vn.com.hkt.pilot.entities.Person;


/**
 *
 * @author khanguct
 */
public interface ICount {

    public int countPerson(Enterprise enterprise, Department department);

    public int countEnterprise();

    public int countDepartmentByEnterprise(Enterprise enterprise);

    public int countProductByEnterprise(Enterprise enterprise);

    public int countOperation(Enterprise enter, Department depar, Person person, Product product);
    
    public int countOperation(Enterprise enter, String date);
    
    public int countOperation(Enterprise enter, String classification, String date);
    
    //////////////// Dem so Operation theo kieu parent-child //////////////////////////////////////
    
    public int countOperationByEnterpriseChild(Enterprise enterprise);
    
    public int countOperationByDepartmentChild(Enterprise enterprise, Department department);
    
    public int countOperationByProductChild(Enterprise enterprise, Product product);
    
    public int countDepartmentByEnterpriseChild(Enterprise enterprise);
    
    public int countPersonByDepartmentChild(Enterprise enterprise, Department department);
    
    public int countPersonByEnterprseChild(Enterprise enterprise);
    
    public int countProductByEnterpriseChild(Enterprise enterprise);
    
    public int countProductByDepartmentChild(Enterprise enterprise, Department department);
        
}
