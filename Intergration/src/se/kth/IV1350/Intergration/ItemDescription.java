package se.kth.IV1350.Intergration;

import se.kth.IV1350.Model.Amount;

public class ItemDescription {

    private final Amount price;
    private final String itemName;
    private final Amount VAT;

    /**
     * creating instance for item description and adding
     * @param price which has the price of the item
     * @param itemName which has the name of the item
     * @param VAT which has the  VAT rate of the item
     */

    public ItemDescription(Amount price, String itemName, Amount VAT){
        this.price = price;
        this.itemName = itemName;
        this.VAT = VAT;
    }

    /**
     * get value of price
     * @return price
     */

    public Amount getPrice(){
        return price;
    }

    /**
     * get the item name
     * @return itemName
     */

    public String getItemName(){
        return itemName;
    }

    /**
     * get the VAT rate of an item
     * @return VAT
     */
    public Amount getVAT() {
        return VAT;
    }
}
