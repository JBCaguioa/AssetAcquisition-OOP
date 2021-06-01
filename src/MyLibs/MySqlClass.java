/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyLibs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author JV
 */
public class MySqlClass {

    Connection myConn = null;
    Statement myStmt = null;
    ResultSet myRs = null;
    
    String user = "root";
    String pass = "password123";
    String connect = "jdbc:mysql://localhost:3306/assetdb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    
    
    public void getConnection() {
        try {
            // 1. Get a connection to database
            myConn = DriverManager.getConnection(connect, user, pass);
        } catch (SQLException se) {
            System.out.println(se.getMessage());
        }
    }

    public void createTable(String office) {
        getConnection();
        try {
            myStmt = myConn.createStatement();
            String qry = "CREATE TABLE " + office + "(ITEM_NUM INT, ITEM_NAME VARCHAR(32), ITEM_CONDITION VARCHAR(50), PRIMARY KEY(ITEM_NUM))";
            myStmt.executeUpdate(qry);
        } catch (SQLException se) {
            System.out.println(se.getMessage());
        }
    }

}
