/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.pilot.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author duong
 */
@Entity
public class Classification {
    @Id
    private String idClassification;
    private String nameClassification; // Phân loại

    /**
     * @return the idClassification
     */
    public String getIdClassification() {
        return idClassification;
    }

    /**
     * @param idClassification the idClassification to set
     */
    public void setIdClassification(String idClassification) {
        this.idClassification = idClassification;
    }

    /**
     * @return the nameClassification
     */
    public String getNameClassification() {
        return nameClassification;
    }

    /**
     * @param nameClassification the nameClassification to set
     */
    public void setNameClassification(String nameClassification) {
        this.nameClassification = nameClassification;
    }

    public Classification(String idClassification, String nameClassification) {
        this.idClassification = idClassification;
        this.nameClassification = nameClassification;
    }
    public Classification(){
        super();
    }

    @Override
    public String toString() {
        return nameClassification;
    }
    
}
