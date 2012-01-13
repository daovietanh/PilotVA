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
public class Department {
    
    @Id
    private String departmentID;
    private String departmentName;
    private String enterpriseID;
    private String personID;// Truong du an
    private String departmentParent;//Dự án mẹ
    private String productID; //  ma San pham
    private String decentralization;

    public String getDecentralization() {
        return decentralization;
    }

    public void setDecentralization(String decentralization) {
        this.decentralization = decentralization;
    }

    /**
     * @return the DepartmentID
     */
    public String getDepartmentID() {
        return departmentID;
    }

    /**
     * @param DepartmentID the DepartmentID to set
     */
    public void setDepartmentID(String DepartmentID) {
        this.departmentID = DepartmentID;
    }

    /**
     * @return the DepartmentName
     */
    public String getDepartmentName() {
        return departmentName;
    }

    /**
     * @param DepartmentName the DepartmentName to set
     */
    public void setDepartmentName(String DepartmentName) {
        this.departmentName = DepartmentName;
    }

    /**
     * @return the EnterpriseID
     */
    public String getEnterpriseID() {
        return enterpriseID;
    }

    /**
     * @param EnterpriseID the EnterpriseID to set
     */
    public void setEnterpriseID(String EnterpriseID) {
        this.enterpriseID = EnterpriseID;
    }

    /**
     * @return the PersonID
     */
    public String getPersonID() {
        return personID;
    }

    /**
     * @param PersonID the PersonID to set
     */
    public void setPersonID(String PersonID) {
        this.personID = PersonID;
    }

    public String getDepartmentParent() {
        return departmentParent;
    }

    public void setDepartmentParent(String departmentParent) {
        this.departmentParent = departmentParent;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    
    public Department(String departmentID, String departmentName, String enterpriseID, String personID, String decentralization, String _departmentParent,String _productID) {
        this.departmentID = departmentID;
        this.departmentName = departmentName;
        this.enterpriseID = enterpriseID;
        this.personID = personID;
        this.decentralization = decentralization;
        this.departmentParent=_departmentParent;
        this.productID=_productID;
    }
    public Department(){
        super();
    }
    @Override
    public String toString(){
        return this.departmentName;
    }
    
    
}
