/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.basic.api;

import vn.com.hkt.pilot.entities.Product;
import java.util.List;
import vn.com.hkt.pilot.entities.Department;
import vn.com.hkt.pilot.entities.Enterprise;

/**
 *
 * @author khanguct
 */
public interface IProductBN {
    public boolean insertProduct(Product prod);
    
    public boolean updateProduct(Product prod);
    
    public boolean deleteProduct(Product prod);
    
    public List<Product> getAllProduct();
    
    public Product getProductByID(String id);
    
    public List<Product> getProductByName(String name);
    
    public List<Product> filterProductByName(String name);
    
    public List<Product> filterProductByID(String id);
    
     public List<Enterprise>  enterpriseHasProduct();
     
     public List<Product> getByEnterprise(Enterprise enterprise);
     
     public List<Product> filterProductByDepartment(Enterprise enterprise, Department department);
}
