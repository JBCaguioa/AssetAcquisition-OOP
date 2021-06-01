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
public class Update implements IManage {

    MySqlClass mySql = new MySqlClass();
    private String office;
    private Item item;
    private int oldItemNum;

    public Update(String office, Item item, int oldItemNum) {
        this.office = office;
        this.item = item;
        this.oldItemNum = oldItemNum;
    }

    @Override
    public void crud() {
        mySql.getConnection();
        try {
            mySql.myStmt = mySql.myConn.createStatement();
            String qry = "UPDATE " + office + " SET ITEM_NUM = " + item.getItemNum() + ", ITEM_NAME = '" + item.getItemName() + "' , ITEM_CONDITION = '" + item.getItemCondition() + "' WHERE ITEM_NUM = " + oldItemNum;
            mySql.myStmt.executeUpdate(qry);
            mySql.myStmt.close();
            JOptionPane.showMessageDialog(null, "Updated successfully!");
        } catch (SQLException se) {
            System.out.println(se.getMessage());
        }
    }

}
