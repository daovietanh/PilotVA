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
public class Nationality {
    @Id
    private String idNationality;
    private String nameNationality;
    private String idCountry;

    /**
     * @return the idNationality
     */
    public String getIdNationality() {
        return idNationality;
    }

    /**
     * @param idNationality the idNationality to set
     */
    public void setIdNationality(String idNationality) {
        this.idNationality = idNationality;
    }

    /**
     * @return the nameNationality
     */
    public String getNameNationality() {
        return nameNationality;
    }

    /**
     * @param nameNationality the nameNationality to set
     */
    public void setNameNationality(String nameNationality) {
        this.nameNationality = nameNationality;
    }

    /**
     * @return the idCountry
     */
    public String getIdCountry() {
        return idCountry;
    }

    /**
     * @param idCountry the idCountry to set
     */
    public void setIdCountry(String idCountry) {
        this.idCountry = idCountry;
    }

    public Nationality(String idNationality, String nameNationality, String idCountry) {
        this.idNationality = idNationality;
        this.nameNationality = nameNationality;
        this.idCountry = idCountry;
    }
     public Nationality(){
         super();
     }

    @Override
    public String toString() {
        return nameNationality;
    }
     
}
