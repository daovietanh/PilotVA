/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.pilot.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author duong
 */
@Entity
public class UnitsOfMeasurement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nameUnits;// đơn vị đo
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameUnits() {
        return nameUnits;
    }

    public void setNameUnits(String nameUnits) {
        this.nameUnits = nameUnits;
    }

    public UnitsOfMeasurement(int id, String nameUnits) {
        this.id = id;
        this.nameUnits = nameUnits;
    }
    
    public UnitsOfMeasurement(){
        super();
    }

    @Override
    public String toString() {
        return this.nameUnits;
    }
    
}
