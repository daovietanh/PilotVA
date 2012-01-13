/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.pilot.operation.viewer.api;

import javax.swing.JPanel;
import org.openide.util.Lookup;

/**
 *
 * @author HKT01
 */
public interface IOperationViewer {
    
    public JPanel getOperationViewer();
    
    public Lookup getOperationViewerLookup();
    
    public double getLevelNumber();
}
