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
public class Enterprise {

    @Id
    private String EnterpriseID;
    private String EnterpriseName;
    private String EnterpriseParent;
    private String Director;
    private String logo;
    private String slogan;

    /**
     * @return the EnterpriseName
     */
    public String getEnterpriseName() {
        return EnterpriseName;
    }

    /**
     * @param EnterpriseName the EnterpriseName to set
     */
    public void setEnterpriseName(String EnterpriseName) {
        this.EnterpriseName = EnterpriseName;
    }

    /**
     * @return the EnterpriseParent
     */
    public String getEnterpriseParent() {
        return EnterpriseParent;
    }

    /**
     * @param EnterpriseParent the EnterpriseParent to set
     */
    public void setEnterpriseParent(String EnterpriseParent) {
        this.EnterpriseParent = EnterpriseParent;
    }

    /**
     * @return the Director
     */
    public String getDirector() {
        return Director;
    }

    /**
     * @param Director the Director to set
     */
    public void setDirector(String Director) {
        this.Director = Director;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    
    public Enterprise(String EnterpriseID, String EnterpriseName, String EnterpriseParent, String Director , String logo,String slogan) {
        this.EnterpriseID = EnterpriseID;
        this.EnterpriseName = EnterpriseName;
        this.EnterpriseParent = EnterpriseParent;
        this.Director = Director;
        this.logo=logo;
        this.slogan=slogan;
    }

    public Enterprise() {
    }

    @Override
    public String toString() {
        return this.EnterpriseName;
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
}
