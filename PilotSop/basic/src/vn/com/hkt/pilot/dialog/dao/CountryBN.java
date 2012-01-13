/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.pilot.dialog.dao;

import com.vn.hkt.generic.api.IGenericAPI;
import java.util.ArrayList;
import java.util.List;
import org.openide.util.Lookup;
import org.openide.util.lookup.ServiceProvider;
import vn.com.hkt.pilot.dialog.api.ICountryBN;
import vn.com.hkt.pilot.entities.Country;

/**
 *
 * @author duong
 */
@ServiceProvider(service = ICountryBN.class)
public class CountryBN implements ICountryBN {

    private IGenericAPI mydao;

    public CountryBN() {
        mydao = Lookup.getDefault().lookup(IGenericAPI.class);
    }

    @Override
    public boolean insertCountry(Country country) {
        if (mydao.insertData(country)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean updateCountry(Country country) {
        if (mydao.updateData(country)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteCountry(Country country) {
        if (mydao.deleteData(Country.class, country.getIdCountry())) {
            return true;
        }
        return false;
    }

    @Override
    public Country getConutryByID(String id) {
        return (Country) mydao.getByID(Country.class, id);
    }

    @Override
    public List<Country> getAllCountry() {
        List<Country> list = new ArrayList<Country>();
        List<Object> obs = new ArrayList<Object>();
        obs = mydao.getAllData(Country.class);
        if (!obs.isEmpty()) {
            int i;
            for (i = 0; i < obs.size(); i++) {
                list.add((Country) obs.get(i));
            }
        }
        return list;
    }

    @Override
    public List<Country> filterByFieldNames(String name) {
        List<Country> list = new ArrayList<Country>();
        List<Object> obs = new ArrayList<Object>();
        obs = mydao.filterByCondition(Country.class, " nameCountry", name);
        if (!obs.isEmpty()) {
            int i;
            for (i = 0; i < obs.size(); i++) {
                list.add((Country) obs.get(i));
            }
        }
        return list;
    }

    @Override
    public List<Country> filterByFieldName(String id) {
        List<Country> list= new ArrayList<Country>();
        List<Object> obs = new ArrayList<Object>();
        obs=mydao.filterByCondition(Country.class,"idCountry", id);
        if(!obs.isEmpty()){
            int i;
            for(i=0;i<obs.size();i++){
                list.add((Country) obs.get(i));
            }
        }
        return list;
    }
}
