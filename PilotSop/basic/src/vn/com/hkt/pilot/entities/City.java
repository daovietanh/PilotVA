/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.pilot.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author duong
 */
public class City {
    @Id
   // @GeneratedValue(strategy=GenerationType.IDENTITY)
   // private int id;
    private String idCity;
    private String nameCity;// tên thành phố
    private String idPartitionDetail;
    
//    @ManyToOne
//    private Country ofCountry;// thuộc đất nước nào

    public String getIdCity() {
        return idCity;
    }

    public void setId(String idCity) {
        this.idCity = idCity;
    }

    public String getNameCity() {
        return nameCity;
    }

    public void setNameCity(String nameCity) {
        this.nameCity = nameCity;
    }

    public String getIdPartitionDetail() {
        return idPartitionDetail;
    }

    public void setIdPartitionDetail(String idPartitionDetail) {
        this.idPartitionDetail = idPartitionDetail;
    }

//    public Country getOfCountry() {
//        return ofCountry;
//    }
//
//    public void setOfCountry(Country ofCountry) {
//        this.ofCountry = ofCountry;
//    }

    public City(String idCity, String nameCity, String idPartitionDetail) {
        this.idCity = idCity;
        this.nameCity = nameCity;
        this.idPartitionDetail = idPartitionDetail;
    }

    
    public City(){
        super();
    }
    @Override
    public String toString(){
        return nameCity;
    }
}
