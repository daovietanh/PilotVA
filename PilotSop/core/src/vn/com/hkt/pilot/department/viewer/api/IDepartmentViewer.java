/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.pilot.department.viewer.api;

import javax.swing.JPanel;
import org.openide.util.Lookup;

/**
 *
 * @author HKT01
 */
public interface IDepartmentViewer {
    
    public JPanel getDepartmentViewer();
    
    public Lookup getDepartmentViewerLookup();
    
    public double getLevelNumber();
}
