package se.kth.IV1350.Intergration;

/**
 * this class represents different items and
 * their discount values
 */

public class ItemRegister {

    public EmployDiscount employDiscount;
    public ItemInventory itemInventory;

    /**
     * create an instance representing item register
     */

    public ItemRegister(){
        this.employDiscount = new EmployDiscount();
        this.itemInventory = new ItemInventory();
    }

    public EmployDiscount getEmployDiscount() {
        return employDiscount;
    }

    public ItemInventory getItemInventory() {
        return itemInventory;
    }
}
