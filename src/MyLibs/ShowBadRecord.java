/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyLibs;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author JV
 */
public class ShowBadRecord implements IRecord{
    MySqlClass mySql = new MySqlClass();

    @Override
    public ArrayList<Item> ShowRecord(String office) {
        ArrayList<Item> items = new ArrayList<Item>();
        String condition1 = "Poor condition";
        String condition2 = "Needs to be disposed";
        String condition3 = "Missing";
        mySql.getConnection();
        try {
            mySql.myStmt = mySql.myConn.createStatement();
            String query = "SELECT * FROM " + office + " WHERE ITEM_CONDITION = '" + condition1 + "' OR ITEM_CONDITION = '" + condition2 + "' OR ITEM_CONDITION = '" + condition3+ "'";
            ResultSet rs = mySql.myStmt.executeQuery(query);

            while (rs.next()) {
                items.add(new Item(rs.getInt("item_Num"), rs.getString("item_Name"), rs.getString("item_Condition")));
            }
            rs.close();
            mySql.myStmt.close();
        } catch (SQLException sex) {
            System.out.println(sex.getMessage());
        }
        return items;
    }
}
