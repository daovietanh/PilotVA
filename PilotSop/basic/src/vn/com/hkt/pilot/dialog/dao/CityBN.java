/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.pilot.dialog.dao;

import com.sun.jmx.remote.internal.ArrayQueue;
import com.vn.hkt.generic.api.IGenericAPI;
import java.util.ArrayList;
import java.util.List;
import org.openide.util.Lookup;
import org.openide.util.lookup.ServiceProvider;
import vn.com.hkt.pilot.dialog.api.ICityBN;
import vn.com.hkt.pilot.entities.City;
import vn.com.hkt.pilot.entities.PartitionDetail;

/**
 *
 * @author duong
 */
@ServiceProvider(service = ICityBN.class)
public class CityBN implements ICityBN {

    private IGenericAPI mydao;

    public CityBN() {
        mydao = Lookup.getDefault().lookup(IGenericAPI.class);
    }

    @Override
    public boolean insertCity(City city) {
        if (mydao.insertData(city)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean updateCity(City city) {
        if (mydao.updateData(city)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteCity(City city) {
        if (mydao.deleteData(City.class, city.getIdCity())) {
            return true;
        }
        return false;

    }

    @Override
    public List<City> getAllCity() {
        List<City> list = new ArrayList<City>();
        List<Object> obs = new ArrayList<Object>();
        obs = mydao.getAllData(City.class);
        if (!obs.isEmpty()) {
            int i;
            for (i = 0; i < obs.size(); i++) {
                list.add((City) obs.get(i));
            }
        }
        return list;
    }

    @Override
    public City getCityById(String id) {
        return (City) mydao.getByID(City.class, id);
    }

    @Override
    public List<City> filterCityByName(String name) {
        List<Object> list = new ArrayList<Object>();
        List<City> result = new ArrayList<City>();
        list = mydao.filterByCondition(City.class, "nameCity", name);
        if (!list.isEmpty()) {
            int i;
            for (i = 0; i < list.size(); i++) {
                result.add((City) list.get(i));
            }
        }
        return result;
    }

    @Override
    public List<City> filterCityByID(String id) {
       List<City> list= new ArrayList<City>();
       List<Object> obs = new ArrayList<Object>();
       obs=mydao.filterByCondition(City.class,"idCity", id);
       if(!obs.isEmpty()){
           int i;
           for(i=0;i<obs.size();i++) {
               list.add((City) obs.get(i));
           }
       }
       return list;
    }
//Lấy danh sách city theo vùng chi tiết
    @Override
    public City getCityByPartitionDetail(PartitionDetail partitionDetail) {
       List<City> list = new ArrayList<City>();
         List<City> list1 = mydao.getAllData(City.class);
          if (!list1.isEmpty()) {
            for (City bean : list1) {
                if (bean.getIdPartitionDetail().equals(partitionDetail.getIdPartitionDetail())) {
                    list.add(bean);
                }
            }
        }
         return (City) list;
    } 
}
