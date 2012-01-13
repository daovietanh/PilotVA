/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.pilot.person.viewer.api;

import javax.swing.JPanel;
import org.openide.util.Lookup;

/**
 *
 * @author HKT01
 */
public interface IPersonExtCreater {
    
    public JPanel getPersonExtCreater();
    
    public Lookup getPersonExtLookup();
    
    public double getLevelNumber();
}
