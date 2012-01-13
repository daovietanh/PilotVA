/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.pilot.dialog.dao;

import com.vn.hkt.generic.api.IGenericAPI;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import org.openide.util.Lookup;
import org.openide.util.lookup.ServiceProvider;
import vn.com.hkt.pilot.dialog.api.INationality;
import vn.com.hkt.pilot.entities.Country;
import vn.com.hkt.pilot.entities.Nationality;

/**
 *
 * @author duong
 */
@ServiceProvider(service = INationality.class)
public class NationalityBN implements INationality {

    private IGenericAPI mydao;

    public NationalityBN() {

        mydao = Lookup.getDefault().lookup(IGenericAPI.class);

    }

    @Override
    public boolean insertNationality(Nationality nationality) {
        if (mydao.insertData(nationality)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean updateNationality(Nationality nationality) {
        if (mydao.updateData(nationality)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteNationality(Nationality nationality) {
        if (mydao.deleteData(Nationality.class, nationality.getIdNationality())) {
            return true;
        }
        return false;
    }

    @Override
    public Nationality getNationalityByID(String id) {
        return (Nationality) mydao.getByID(Nationality.class, id);
    }

    @Override
    public List<Nationality> getAllNationality() {
        List<Nationality> list = new ArrayList<Nationality>();
        List<Object> obs = new ArrayList<Object>();
        obs = mydao.getAllData(Nationality.class);
        if (!obs.isEmpty()) {
            int i;
            for (i = 0; i < obs.size(); i++) {
                list.add((Nationality) obs.get(i));
            }
        }
        return list;
    }

    @Override
    public List<Nationality> filterNationalityByID(String id) {
        List<Nationality> result = new ArrayList<Nationality>();
        List<Object> list = new ArrayList<Object>();
        list = mydao.filterByCondition(Nationality.class, "idNationality", id);
        if (!list.isEmpty()) {
            int i;
            for (i = 0; i < list.size(); i++) {
                result.add((Nationality) list.get(i));
            }
        }
        return result;
    }

    @Override
    public List<Nationality> filterNationalityByName(String name) {
        List<Nationality> result = new ArrayList<Nationality>();
        List<Object> list = new ArrayList<Object>();
        list = mydao.filterByCondition(Nationality.class, "nameNationality", name);
        if (!list.isEmpty()) {
            int i;
            for (i = 0; i < list.size(); i++) {
                result.add((Nationality) list.get(i));
            }
        }
        return result;
    }

    @Override
    public List<Nationality> getNationalityByCountry(Country country) {
        List<Nationality> list = new ArrayList<Nationality>();
         List<Nationality> list1 =mydao.getAllData(Nationality.class);
          if(!list1.isEmpty()){
            for(Nationality bean : list1){
                if(bean.getIdCountry().equals(country.getIdCountry())){
                    list.add(bean);
                }
            }
        }
        return list;        
    }
}
