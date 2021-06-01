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
public class Delete implements IManage {

    MySqlClass mySql = new MySqlClass();
    private String office;
    private int oldItemNum;

    public Delete(String office, int oldItemNum) {
        this.office = office;
        this.oldItemNum = oldItemNum;
    }

    @Override
    public void crud() {
        mySql.getConnection();
        try {
            mySql.myStmt = mySql.myConn.createStatement();
            String qry = "DELETE FROM " + office + " WHERE ITEM_NUM = " + oldItemNum;
            mySql.myStmt.executeUpdate(qry);
            mySql.myStmt.close();
            JOptionPane.showMessageDialog(null, "Deleted successfully!");
        } catch (SQLException se) {
            System.out.println(se.getMessage());
        }
    }

}
