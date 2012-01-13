/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.basic.api;

import java.util.List;
import vn.com.hkt.pilot.entities.Classification;

/**
 *
 * @author duong
 */
public interface IClassification {

    public boolean insertClassification(Classification classification);//

    public boolean updateClassification(Classification classification);// 

    public boolean deleteClassification(Classification classification);//    

    public List<Classification> getAllClassification();// 

    public List<Classification> filterCityByID(String name);
    
     public Classification getConutryByID(String id);
}
