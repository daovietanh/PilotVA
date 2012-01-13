/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.hkt.core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author home
 */
public class DBConnection {

    public static void closeResultSet(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void closeStatement(PreparedStatement pstm) {
        if (pstm != null) {
            try {
                pstm.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void closeConnection(Connection con) {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static Connection openConnection() {
        Connection con = null;
        try {
            Class.forName("org.h2.Driver");
            //De ket noi voi server trong mang LAN thi thay localhost bang IP cua may server
            con = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/EnterpriseManager", "sa", "");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return con;
    }
}
