/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.authorization.api;

import com.vn.hkt.core.Permission;
import com.vn.hkt.core.Window;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author home
 */
public interface IAuthorization {

    public Vector loadUsers();

    public Permission checkPermission(int userID, int windowID);

    public Permission getUserIDByName(String userName);

    public Window getWindowIDByName(String windowName);

    public Window getWindowNameByID(int windowID);

    public List<Permission> getLockWindowByUserID(int userID);

    public List<Permission> getViewWindowByUserID(int userID);

    public List<Permission> getUpdateWindowByUserID(int userID);

    public boolean setPermissionAtUpdateList(int userID, int windowID);

    public boolean setPermissionAtViewList(int userID, int windowID);

    public boolean setPermissionAtLockList(int userID, int windowID);
}
