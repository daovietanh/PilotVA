/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.pilot.enterprise.viewer.api;

import javax.swing.JPanel;
import org.openide.util.Lookup;

/**
 *
 * @author khanguct
 */
public interface IEnterpriseExtCreator {
    
    public JPanel getEnterpriseExtCreator();
    
    public Lookup getEnterpriseExtLookup();
    
    public double getLevelNumber();
    
}
