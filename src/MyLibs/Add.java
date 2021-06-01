/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyLibs;

import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author JV
 */
public class Add implements IManage {

    MySqlClass mySql = new MySqlClass();
    private String office;
    private Item item;

    public Add(String office, Item item) {
        this.office = office;
        this.item = item;
    }

    @Override
    public void crud() {
        mySql.getConnection();
        try {
            mySql.myStmt = mySql.myConn.createStatement();
            String qry = "INSERT INTO " + office + " VALUES(" + item.getItemNum() + ",'" + item.getItemName() + "','" + item.getItemCondition() + "')";
            mySql.myStmt.executeUpdate(qry);
            mySql.myStmt.close();
            JOptionPane.showMessageDialog(null, "Added successfully!");
        } catch (SQLException se) {
            String msg = "Cannot add. item" + item.getItemNum() + " already exists!";
            JOptionPane.showMessageDialog(null, msg);
        }
    }

}
