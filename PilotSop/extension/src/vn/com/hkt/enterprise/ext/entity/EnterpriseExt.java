/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.enterprise.ext.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author khanguct
 */
@Entity
public class EnterpriseExt{
    
    @Id
    private String EnterpriseID;
    private String EnterpriseName;
    private String EnterpriseAddress;
    private String EnterpriseTel;
    private String EnterpriseEmail;
    private String EnterpriseFax;
    private String EnterpriseWeb;

    public EnterpriseExt() {
    }

    public EnterpriseExt(String EnterpriseID, String EnterpriseName, String EnterpriseAddress, String EnterpriseTel, String EnterpriseEmail, String EnterpriseFax, String EnterpriseWeb) {
        this.EnterpriseID = EnterpriseID;
        this.EnterpriseName = EnterpriseName;
        this.EnterpriseAddress = EnterpriseAddress;
        this.EnterpriseTel = EnterpriseTel;
        this.EnterpriseEmail = EnterpriseEmail;
        this.EnterpriseFax = EnterpriseFax;
        this.EnterpriseWeb = EnterpriseWeb;
    }

    public String getEnterpriseAddress() {
        return EnterpriseAddress;
    }

    public void setEnterpriseAddress(String EnterpriseAddress) {
        this.EnterpriseAddress = EnterpriseAddress;
    }

    public String getEnterpriseEmail() {
        return EnterpriseEmail;
    }

    public void setEnterpriseEmail(String EnterpriseEmail) {
        this.EnterpriseEmail = EnterpriseEmail;
    }

    public String getEnterpriseFax() {
        return EnterpriseFax;
    }

    public void setEnterpriseFax(String EnterpriseFax) {
        this.EnterpriseFax = EnterpriseFax;
    }

    public String getEnterpriseID() {
        return EnterpriseID;
    }

    public void setEnterpriseID(String EnterpriseID) {
        this.EnterpriseID = EnterpriseID;
    }

    public String getEnterpriseName() {
        return EnterpriseName;
    }

    public void setEnterpriseName(String EnterpriseName) {
        this.EnterpriseName = EnterpriseName;
    }

    public String getEnterpriseTel() {
        return EnterpriseTel;
    }

    public void setEnterpriseTel(String EnterpriseTel) {
        this.EnterpriseTel = EnterpriseTel;
    }

    public String getEnterpriseWeb() {
        return EnterpriseWeb;
    }

    public void setEnterpriseWeb(String EnterpriseWeb) {
        this.EnterpriseWeb = EnterpriseWeb;
    }

    
    @Override
    public String toString() {
        return EnterpriseID;
    }
    
    
}
