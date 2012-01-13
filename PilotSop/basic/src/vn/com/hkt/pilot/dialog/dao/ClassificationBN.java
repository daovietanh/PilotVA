/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.pilot.dialog.dao;

import com.vn.hkt.generic.api.IGenericAPI;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.openide.util.Lookup;
import org.openide.util.lookup.ServiceProvider;
import vn.com.hkt.pilot.dialog.api.IClassification;
import vn.com.hkt.pilot.entities.Classification;

/**
 *
 * @author duong
 */
@ServiceProvider(service=IClassification.class)
public class ClassificationBN implements IClassification {

    private IGenericAPI mydao;

    public ClassificationBN() {
        
        mydao = Lookup.getDefault().lookup(IGenericAPI.class);
       
    }
    @Override
    public boolean insertClassification(Classification classification) {
        if (mydao.insertData(classification)) {
            return true;
        }
       
        return false;
    }

    @Override
    public boolean updateClassification(Classification classification) {
       if (mydao.updateData(classification)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteClassification(Classification classification) {
          if (mydao.deleteData(Classification.class, classification.getIdClassification())) {
            return true;
        }
        return false;
    }

    @Override
    public List<Classification> getAllClassification() {
        List<Classification> list = new ArrayList<Classification>();
        List<Object> obs = new ArrayList<Object>();
        obs = mydao.getAllData(Classification.class);
        if(!obs.isEmpty()){
            int i;
            for(i=0;i<obs.size();i++){
                 list.add( (Classification)obs.get(i));                              
            }
        }
        return list;
    }
 
    @Override
    public List<Classification> filterCityByID(String name) {
         List<Classification> list = new ArrayList<Classification>();
        List<Object> obs = new ArrayList<Object>();
        obs = mydao.filterByCondition(Classification.class, "nameClassification", name);
        if(!obs.isEmpty()){
            int i;
            for(i=0;i<obs.size();i++){
                 list.add( (Classification)obs.get(i));                              
            }
        }
        return list;
    }

    @Override
    public Classification getConutryByID(String id) {
         return (Classification)mydao.getByID(Classification.class, id);
    }

}