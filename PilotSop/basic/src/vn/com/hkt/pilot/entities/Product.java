/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.pilot.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author khanguct
 */
@Entity
public class Product {

    @Id
    private String ProductID;
    private String ProductName;
    private String EnterpriseID;
    private String DepartmentID;
    private String PersonID;// Nguoi sang lap
    private String productgroups;

    @Override
    public String toString() {
        return this.ProductName;
    }

    /**
     * @return the ProductID
     */
    public String getProductID() {
        return ProductID;
    }

    /**
     * @param ProductID the ProductID to set
     */
    public void setProductID(String ProductID) {
        this.ProductID = ProductID;
    }

    /**
     * @return the ProductName
     */
    public String getProductName() {
        return ProductName;
    }

    /**
     * @param ProductName the ProductName to set
     */
    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }

    /**
     * @return the EnterpriseID
     */
    public String getEnterpriseID() {
        return EnterpriseID;
    }

    /**
     * @param EnterpriseID the EnterpriseID to set
     */
    public void setEnterpriseID(String EnterpriseID) {
        this.EnterpriseID = EnterpriseID;
    }

    /**
     * @return the DepartmentID
     */
    public String getDepartmentID() {
        return DepartmentID;
    }

    /**
     * @param DepartmentID the DepartmentID to set
     */
    public void setDepartmentID(String DepartmentID) {
        this.DepartmentID = DepartmentID;
    }

    /**
     * @return the PersonID
     */
    public String getPersonID() {
        return PersonID;
    }

    /**
     * @param PersonID the PersonID to set
     */
    public void setPersonID(String PersonID) {
        this.PersonID = PersonID;
    }

    public String getProductgroups() {
        return productgroups;
    }

    public void setProductgroups(String productgroups) {
        this.productgroups = productgroups;
    }

    public Product(String ProductID, String ProductName, String EnterpriseID, String DepartmentID, String PersonID, String _productgroups) {
        this.ProductID = ProductID;
        this.ProductName = ProductName;
        this.EnterpriseID = EnterpriseID;
        this.DepartmentID = DepartmentID;
        this.PersonID = PersonID;
        this.productgroups=_productgroups;
    }

    public Product() {
    }
}
