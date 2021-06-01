/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyLibs;

/**
 *
 * @author JV
 */
public class Item {

    private int itemNum;
    private String itemName;
    private String itemCondition;

    public Item(int itemNum, String itemName, String itemCondition) {
        this.itemNum = itemNum;
        this.itemName = itemName;
        this.itemCondition = itemCondition;
    }

    public int getItemNum() {
        return itemNum;
    }

    public String getItemName() {
        return itemName;
    }

    public String getItemCondition() {
        return itemCondition;
    }

}
