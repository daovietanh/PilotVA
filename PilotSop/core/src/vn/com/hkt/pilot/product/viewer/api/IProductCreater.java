/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.pilot.product.viewer.api;

import javax.swing.JPanel;
import org.openide.util.Lookup;

/**
 *
 * @author HKT01
 */
public interface IProductCreater {
    
    public JPanel getProductCreater();
    
    public Lookup getProductLookup();
    
    public double getLevelNumber();
    
}
