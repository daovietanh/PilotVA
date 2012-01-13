/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.authorization.spi;

import com.vn.hkt.core.DBConnection;
import com.vn.hkt.core.Permission;
import com.vn.hkt.core.Window;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import org.openide.util.Exceptions;
import org.openide.util.lookup.ServiceProvider;
import vn.com.hkt.authorization.api.IAuthorization;

/**
 *
 * @author home
 */
@ServiceProvider(service = IAuthorization.class)
public class UserControl implements IAuthorization {

    @Override
    public Vector loadUsers() {
        Vector data = new Vector();
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        conn = DBConnection.openConnection();
        try {
            pstm = conn.prepareStatement("select userID, userName, password, personID, departmentName from Account, Department where Account.DeparmentID= Department.DepartmentID");
            rs = pstm.executeQuery();
            while (rs.next()) {
                Vector v = new Vector();
                v.addElement(rs.getInt("userID"));
                v.addElement(rs.getString("username"));
                v.addElement(rs.getString("password"));
                v.addElement(rs.getString("personID"));
                v.addElement(rs.getString("groupName"));
                data.add(v);
            }
        } catch (Exception ex) {
            Exceptions.printStackTrace(ex);
        } finally {
            DBConnection.closeResultSet(rs);
            DBConnection.closeStatement(pstm);
            DBConnection.closeConnection(conn);
        }
        return data;
    }

    @Override
    public Permission checkPermission(int userID, int windowID) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Permission p = new Permission();
        conn = DBConnection.openConnection();
        try {
            pstm = conn.prepareStatement("select * from Permission where userID=? and windowID=?");
            pstm.setInt(1, userID);
            pstm.setInt(2, windowID);
            rs = pstm.executeQuery();
            while (rs.next()) {
                p.setUserID(rs.getInt("userID"));
                p.setWindowID(rs.getInt("windowID"));
                p.setUpdatePermission(rs.getBoolean("updatePermission"));
                p.setViewPermission(rs.getBoolean("viewPermission"));
                p.setLock(rs.getBoolean("lock"));
            }
        } catch (Exception ex) {
            Exceptions.printStackTrace(ex);
        } finally {
            DBConnection.closeResultSet(rs);
            DBConnection.closeStatement(pstm);
            DBConnection.closeConnection(conn);
        }
        return p;
    }

    @Override
    public Permission getUserIDByName(String userName) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Permission p = new Permission();
        conn = DBConnection.openConnection();
        try {
            pstm = conn.prepareStatement("select userID from Account where userName=?");
            pstm.setString(1, userName);
            rs = pstm.executeQuery();
            while (rs.next()) {
                p.setUserID(rs.getInt("userName"));
            }
        } catch (Exception ex) {
            Exceptions.printStackTrace(ex);
        } finally {
            DBConnection.closeResultSet(rs);
            DBConnection.closeStatement(pstm);
            DBConnection.closeConnection(conn);
        }
        return p;
    }

    @Override
    public Window getWindowIDByName(String windowName) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Window w = new Window();
        conn = DBConnection.openConnection();
        try {
            pstm = conn.prepareStatement("select * from window where windowName=?");
            pstm.setString(1, windowName);
            rs = pstm.executeQuery();
            while (rs.next()) {
                w.setWindowID(rs.getInt("windowID"));
                w.setWindowName(rs.getString("windowName"));
            }
        } catch (Exception ex) {
            Exceptions.printStackTrace(ex);
        } finally {
            DBConnection.closeResultSet(rs);
            DBConnection.closeStatement(pstm);
            DBConnection.closeConnection(conn);
        }
        return w;
    }

    @Override
    public Window getWindowNameByID(int windowID) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Window w = new Window();
        conn = DBConnection.openConnection();
        try {
            pstm = conn.prepareStatement("select * from window where windowID=?");
            pstm.setInt(1, windowID);
            rs = pstm.executeQuery();
            while (rs.next()) {
                w.setWindowID(rs.getInt("windowID"));
                w.setWindowName(rs.getString("windowName"));
            }
        } catch (Exception ex) {
            Exceptions.printStackTrace(ex);
        } finally {
            DBConnection.closeResultSet(rs);
            DBConnection.closeStatement(pstm);
            DBConnection.closeConnection(conn);
        }
        return w;
    }

    @Override
    public List<Permission> getLockWindowByUserID(int userID) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Permission> list = new ArrayList<Permission>();

        conn = DBConnection.openConnection();
        try {
            pstm = conn.prepareStatement("select w.windowID,w.windowName from window as w, Permission as p where w.windowID=p.windowID and p.userID=? and p.lock=true");
            pstm.setInt(1, userID);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Permission p = new Permission();
                p.setWindowID(rs.getInt("windowID"));
                p.setWindowName(rs.getString("windowName"));
                list.add(p);
            }
        } catch (Exception ex) {
            Exceptions.printStackTrace(ex);
        } finally {
            DBConnection.closeResultSet(rs);
            DBConnection.closeStatement(pstm);
            DBConnection.closeConnection(conn);
        }
        return list;
    }

    @Override
    public List<Permission> getViewWindowByUserID(int userID) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Permission> list = new ArrayList<Permission>();

        conn = DBConnection.openConnection();
        try {
            pstm = conn.prepareStatement("select w.windowID,w.windowName from window as w, Permission as p where w.windowID=p.windowID and p.userID=? and p.viewPermission=true");
            pstm.setInt(1, userID);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Permission p = new Permission();
                p.setWindowID(rs.getInt("windowID"));
                p.setWindowName(rs.getString("windowName"));
                list.add(p);
            }
        } catch (Exception ex) {
            Exceptions.printStackTrace(ex);
        } finally {
            DBConnection.closeResultSet(rs);
            DBConnection.closeStatement(pstm);
            DBConnection.closeConnection(conn);
        }
        return list;
    }

    @Override
    public List<Permission> getUpdateWindowByUserID(int userID) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Permission> list = new ArrayList<Permission>();

        conn = DBConnection.openConnection();
        try {
            pstm = conn.prepareStatement("select w.windowID,w.windowName from window as w, Permission as p where w.windowID=p.windowID and p.userID=? and p.updatepermission=true");
            pstm.setInt(1, userID);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Permission p = new Permission();
                p.setWindowID(rs.getInt("windowID"));
                p.setWindowName(rs.getString("windowName"));
                list.add(p);
            }
        } catch (Exception ex) {
            Exceptions.printStackTrace(ex);
        } finally {
            DBConnection.closeResultSet(rs);
            DBConnection.closeStatement(pstm);
            DBConnection.closeConnection(conn);
        }
        return list;
    }

    @Override
    public boolean setPermissionAtUpdateList(int userID, int windowID) {
        Connection conn = null;
        PreparedStatement pstm = null;
        conn = DBConnection.openConnection();
        try {
            pstm = conn.prepareStatement("update permission set viewPermission=false, updatePermission=true, lock=false where userID=? and windowID=?");
            pstm.setInt(1, userID);
            pstm.setInt(2, windowID);
            pstm.executeUpdate();
            return true;
        } catch (Exception ex) {
            Exceptions.printStackTrace(ex);
            return false;
        } finally {
            DBConnection.closeStatement(pstm);
            DBConnection.closeConnection(conn);
        }
    }

    @Override
    public boolean setPermissionAtViewList(int userID, int windowID) {
        Connection conn = null;
        PreparedStatement pstm = null;
        conn = DBConnection.openConnection();
        try {
            pstm = conn.prepareStatement("update permission set viewPermission=true, updatePermission=false, lock=false where userID=? and windowID=?");
            pstm.setInt(1, userID);
            pstm.setInt(2, windowID);
            pstm.executeUpdate();
            return true;
        } catch (Exception ex) {
            Exceptions.printStackTrace(ex);
            return false;
        } finally {
            DBConnection.closeStatement(pstm);
            DBConnection.closeConnection(conn);
        }
    }

    @Override
    public boolean setPermissionAtLockList(int userID, int windowID) {
        Connection conn = null;
        PreparedStatement pstm = null;
        conn = DBConnection.openConnection();
        try {
            pstm = conn.prepareStatement("update permission set viewPermission=false, updatePermission=false, lock=true where userID=? and windowID=?");
            pstm.setInt(1, userID);
            pstm.setInt(2, windowID);
            pstm.executeUpdate();
            return true;
        } catch (Exception ex) {
            Exceptions.printStackTrace(ex);
            return false;
        } finally {
            DBConnection.closeStatement(pstm);
            DBConnection.closeConnection(conn);
        }
    }
}
