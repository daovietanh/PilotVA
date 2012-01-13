/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.pilot.dialog.api;

import java.util.List;
import vn.com.hkt.pilot.entities.UnitsOfMeasurement;

/**
 *
 * @author duong
 */
public interface IUnitsOfMeasurement {

    public boolean insertUnitsOfMeasurement(UnitsOfMeasurement unitsOfMeasurement);

    public boolean updateUnitsOfMeasurement(UnitsOfMeasurement unitsOfMeasurement);

    public boolean deleteUnitsOfMeasurement(UnitsOfMeasurement unitsOfMeasurement);

    public List<UnitsOfMeasurement> getAllUnitsOfMeasurement();

    public List<UnitsOfMeasurement> filterUnitsOfMeasurementByName(String name);

    public UnitsOfMeasurement getConutryByID(int id);
    
}
