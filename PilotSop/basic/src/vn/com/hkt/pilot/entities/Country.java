/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.pilot.entities;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author duong
 */
@Entity
public class Country {

    // public final static String NAME_COUNTRY = "nameCountry";
    @Id
    //  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String idCountry;
    private String nameCountry;
    // @OneToMany(cascade = CascadeType.REMOVE)// khi 1 d?t nu?c b? xóa thì các thành ph? thu?c d?t nu?c d?y cung b? xóa
    //  private List<City> listCity;// danh sách thành ph? tr?c thu?c 1 d?t nu?c        

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

    /**
     * @return the nameCountry
     */
    public String getNameCountry() {
        return nameCountry;
    }

    /**
     * @param nameCountry the nameCountry to set
     */
    public void setNameCountry(String nameCountry) {
        this.nameCountry = nameCountry;
    }

    public Country(String idCountry, String nameCountry) {
        this.idCountry = idCountry;
        this.nameCountry = nameCountry;
    }

    public Country() {
        super();
    }

    @Override
    public String toString() {
        return nameCountry;
    }
}
