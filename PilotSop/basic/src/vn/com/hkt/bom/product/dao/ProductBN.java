/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.bom.product.dao;

import com.vn.hkt.generic.api.IGenericAPI;
import java.util.ArrayList;
import java.util.List;
import org.openide.util.Lookup;
import org.openide.util.lookup.ServiceProvider;
import vn.com.hkt.basic.api.IProductBN;
import vn.com.hkt.pilot.entities.Department;
import vn.com.hkt.pilot.entities.Enterprise;
import vn.com.hkt.pilot.entities.Product;

/**
 *
 * @author khangphamngoc
 */
@ServiceProvider(service=IProductBN.class)
public class ProductBN implements IProductBN{
    
    private IGenericAPI mydao;

    public ProductBN() {
        
        this.mydao = Lookup.getDefault().lookup(IGenericAPI.class);
    }
    
    

    @Override
    public boolean insertProduct(Product prod) {
        if(mydao.insertData(prod))return true;
        return false;
    }

    @Override
    public boolean updateProduct(Product prod) {
        if(mydao.updateData(prod))return true;
        return false;
    }

    @Override
    public boolean deleteProduct(Product prod) {
        if(mydao.deleteData(Product.class, prod.getProductID()))return true;
        return false;
    }

    @Override
    public List<Product> getAllProduct() {
        List<Product> list= new ArrayList<Product>();
        List<Object> obs = new ArrayList<Object>();
        obs = mydao.getAllData(Product.class);
        if(!obs.isEmpty()){
            int i;
            for(i=0;i<obs.size();i++){
                list.add((Product)obs.get(i));
            }
        }
        return list;
    }

    @Override
    public Product getProductByID(String id) {
        return (Product)mydao.getByID(Product.class, id);
    }

    @Override
    public List<Product> getProductByName(String name) {
        List<Product> list = new ArrayList<Product>();
        List<Product> result = new ArrayList<Product>();
        list = getAllProduct();
        if(!list.isEmpty()){
            int i;
            for(i=0;i<list.size();i++){
                Product bean = list.get(i);
                if(bean.getProductName().equals(name)){
                    result.add(bean);
                }
            }
        }
        return result;
    }

    @Override
    public List<Product> filterProductByName(String name) {
       List<Object> list = new ArrayList<Object>();
        List<Product> result = new ArrayList<Product>();
        list = mydao.filterByCondition(Product.class, "ProductName", name);
        if(!list.isEmpty()){
            int i;
            for(i=0;i<list.size();i++){
               result.add((Product)list.get(i));
            }
        }
        return result;
    }

    @Override
    public List<Product> filterProductByID(String id) {
        List<Object> list = new ArrayList<Object>();
        List<Product> result = new ArrayList<Product>();
        list = mydao.filterByCondition(Product.class, "ProductID", id);
        if(!list.isEmpty()){
            int i;
            for(i=0;i<list.size();i++){
               result.add((Product)list.get(i));
            }
        }
        return result;
    }

    @Override
    public List<Enterprise> enterpriseHasProduct() {
        
        String sql =  "SELECT enter  FROM Enterprise enter" 
               +" where enter.EnterpriseName IN (Select sp.EnterpriseID from Product sp)";
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
    public List<Product> getByEnterprise(Enterprise enterprise) {
         List<Product> list = new ArrayList<Product>();
        List<Product> list1 = mydao.getAllData(Product.class);
        if(!list1.isEmpty()){
            for(Product bean : list1){
                if(bean.getEnterpriseID().equals(enterprise.getEnterpriseID())){
                    list.add(bean);
                }
            }
        }
        return list;
    }

    @Override
    public List<Product> filterProductByDepartment(Enterprise enterprise, Department department) {
        List<Product> list = new ArrayList<Product>();
        List<Product> list1 = new ArrayList<Product>();
        list1 = getByEnterprise(enterprise);
        if(!list1.isEmpty()){
            for(Product bean : list1){
                if(bean.getDepartmentID().equals(department.getDepartmentName())){
                    list.add(bean);
                }
            }
        }
        return list;
    }
    
}
