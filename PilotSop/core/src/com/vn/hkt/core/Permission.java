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
public class Permission {

    @Id
    @GeneratedValue
    private String permissionID;
    private int userID;
    private int windowID;
    private String windowName;
    private boolean updatePermission;
    private boolean viewPermission;
    private boolean lock;

    public Permission() {
    }

    public Permission(int userID, int windowID, String windowName, boolean updatePermission, boolean viewPermission, boolean lock) {
        this.userID = userID;
        this.windowID = windowID;
        this.windowName = windowName;
        this.updatePermission = updatePermission;
        this.viewPermission = viewPermission;
        this.lock = lock;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getWindowName() {
        return windowName;
    }

    public void setWindowName(String windowName) {
        this.windowName = windowName;
    }

    public boolean isLock() {
        return lock;
    }

    public void setLock(boolean lock) {
        this.lock = lock;
    }

    public String getPermissionID() {
        return permissionID;
    }

    public void setPermissionID(String permissionID) {
        this.permissionID = permissionID;
    }

    public boolean isUpdatePermission() {
        return updatePermission;
    }

    public void setUpdatePermission(boolean updatePermission) {
        this.updatePermission = updatePermission;
    }

    public boolean isViewPermission() {
        return viewPermission;
    }

    public void setViewPermission(boolean viewPermission) {
        this.viewPermission = viewPermission;
    }

    public int getWindowID() {
        return windowID;
    }

    public void setWindowID(int windowID) {
        this.windowID = windowID;
    }
}
