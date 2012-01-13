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
public class Person {

    @Id
    private String PersonID;//Ma
    private String FirstName;
    private String LastName;
    private String EnterpriseID;//ma ty 
    private String DepartmentName;// ten bo phan phong
    private String position;//Chuc vu
    private String image;// ảnh

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

    /**
     * @return the FirstName
     */
    public String getFirstName() {
        return FirstName;
    }

    /**
     * @param FirstName the FirstName to set
     */
    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    /**
     * @return the LastName
     */
    public String getLastName() {
        return LastName;
    }

    /**
     * @param LastName the LastName to set
     */
    public void setLastName(String LastName) {
        this.LastName = LastName;
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
     * @return the DepartmentName
     */
    public String getDepartmentName() {
        return this.DepartmentName;
    }

    @Override
    public String toString() {
        return this.FirstName +" "+ this.LastName;
    }

    /**
     * @param DepartmentName the DepartmentName to set
     */
    public void setDepartmentName(String DepartmentName) {
        this.DepartmentName = DepartmentName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    
    public Person(String PersonID, String FirstName, String LastName, String EnterpriseID, String DepartmentName, String position ,String image) {
        this.PersonID = PersonID;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.EnterpriseID = EnterpriseID;
        this.DepartmentName = DepartmentName;
        this.position = position;
        this.image=image;
    }

    public Person() {
        super();
    }
}
