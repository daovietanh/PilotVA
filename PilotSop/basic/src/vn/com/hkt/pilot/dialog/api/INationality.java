/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.pilot.dialog.api;

import java.util.List;
import vn.com.hkt.pilot.entities.Country;
import vn.com.hkt.pilot.entities.Nationality;

/**
 *
 * @author duong
 */
public interface INationality {

    public boolean insertNationality(Nationality nationality);

    public boolean updateNationality(Nationality nationality);

    public boolean deleteNationality(Nationality nationality);

    public Nationality getNationalityByID(String id);

    public List<Nationality> getAllNationality();

    public List<Nationality> filterNationalityByID(String id);

    public List<Nationality> filterNationalityByName(String name);
    
    public List<Nationality> getNationalityByCountry (Country country);
}
