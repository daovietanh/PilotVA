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
import vn.com.hkt.pilot.dialog.api.IUnitsOfMeasurement;
import vn.com.hkt.pilot.entities.UnitsOfMeasurement;

/**
 *
 * @author duong
 */
@ServiceProvider(service = IUnitsOfMeasurement.class)
public class UnitsOfMeasurementBN implements IUnitsOfMeasurement {

    private IGenericAPI mydao;

    public UnitsOfMeasurementBN() {

        mydao = Lookup.getDefault().lookup(IGenericAPI.class);
    }

    @Override
    public boolean insertUnitsOfMeasurement(UnitsOfMeasurement unitsOfMeasurement) {
       if (mydao.insertData(unitsOfMeasurement)) {
            return true;
        }
       
        return false;
    }

    @Override
    public boolean updateUnitsOfMeasurement(UnitsOfMeasurement unitsOfMeasurement) {
        if (mydao.updateData(unitsOfMeasurement)) {
            return true;
        }
       
        return false;
    }

    @Override
    public boolean deleteUnitsOfMeasurement(UnitsOfMeasurement unitsOfMeasurement) {
        if (mydao.removeData(UnitsOfMeasurement.class, unitsOfMeasurement.getId())) {
            return true;
        }
        return false;
    }

    @Override
    public List<UnitsOfMeasurement> getAllUnitsOfMeasurement() {
        List<UnitsOfMeasurement> list = new ArrayList<UnitsOfMeasurement>();
        List<Object> obs = new ArrayList<Object>();
        obs = mydao.getAllData(UnitsOfMeasurement.class);
        if(!obs.isEmpty()){
            int i;
            for(i=0;i<obs.size();i++){
                 list.add( (UnitsOfMeasurement)obs.get(i));                              
            }
        }
        return list;
    }

    @Override
    public List<UnitsOfMeasurement> filterUnitsOfMeasurementByName(String name) {
        List<UnitsOfMeasurement> list = new ArrayList<UnitsOfMeasurement>();
        List<Object> obs = new ArrayList<Object>();
        obs = mydao.filterByCondition(UnitsOfMeasurement.class, "nameUnits", name);
        if(!obs.isEmpty()){
            int i;
            for(i=0;i<obs.size();i++){
                 list.add( (UnitsOfMeasurement)obs.get(i));                              
            }
        }
        return list;
        
    }

    @Override
    public UnitsOfMeasurement getConutryByID(int id) {
          return (UnitsOfMeasurement)mydao.getByID(UnitsOfMeasurement.class, id);
    }
}
