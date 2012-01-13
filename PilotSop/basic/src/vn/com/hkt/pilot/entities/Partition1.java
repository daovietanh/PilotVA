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
public class Partition1 {
    @Id
    private String idPartition1; // mã vùng 1
    private String namePartion1;    //tên vùng 1
    private String idCountry; //Mã quốc gia

    /**
     * @return the idPartition1
     */
    public String getIdPartition1() {
        return idPartition1;
    }

    /**
     * @param idPartition1 the idPartition1 to set
     */
    public void setIdPartition1(String idPartition1) {
        this.idPartition1 = idPartition1;
    }

    /**
     * @return the namePartion1
     */
    public String getNamePartion1() {
        return namePartion1;
    }

    /**
     * @param namePartion1 the namePartion1 to set
     */
    public void setNamePartion1(String namePartion1) {
        this.namePartion1 = namePartion1;
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

    public Partition1(String idPartition1, String namePartion1, String idCountry) {
        this.idPartition1 = idPartition1;
        this.namePartion1 = namePartion1;
        this.idCountry = idCountry;
    }
    public Partition1(){
        super();
    }

    @Override
    public String toString() {
        return namePartion1;
    }
            
}
