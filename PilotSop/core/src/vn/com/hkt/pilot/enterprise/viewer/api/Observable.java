/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.pilot.enterprise.viewer.api;

/**
 *
 * @author longnt
 */
public interface Observable {
    public void notifyObservers(Object arg);
    public void setChanged();
    public void clearChanged();
    
}
