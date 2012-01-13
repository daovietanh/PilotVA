/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.pilot.dialog.api;

import java.util.List;
import vn.com.hkt.pilot.entities.Country;

/**
 *
 * @author duong
 */
public interface ICountryBN {

    public boolean insertCountry(Country country);

    public boolean updateCountry(Country country);

    public boolean deleteCountry(Country country);

    public Country getConutryByID(String id);

    public List<Country> getAllCountry();
    
    public List<Country> filterByFieldName(String id);

    public List<Country> filterByFieldNames(String name);
    
    
}
