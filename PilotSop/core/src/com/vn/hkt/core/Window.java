/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.hkt.core;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author home
 */
@Entity
public class Window {

    @Id
    @GeneratedValue
    private int windowID;
    private String windowName;

    public Window() {
    }

    public Window(String windowName) {
        this.windowName = windowName;
    }

    public int getWindowID() {
        return windowID;
    }

    public void setWindowID(int windowID) {
        this.windowID = windowID;
    }

    public String getWindowName() {
        return windowName;
    }

    public void setWindowName(String windowName) {
        this.windowName = windowName;
    }
}
