/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyLibs;

import MyApp.*;

/**
 *
 * @author JV
 */
public class RecordFactory {

    public IRecord getRecord(int choice) {
        if (choice == 1) {
            return new ShowBadRecord();
        }
        if (choice == 2) {
            return new ShowGoodRecord();
        }
        if (choice == 3) {
            return new ShowAllRecord();
        }
        return null;
    }

}
