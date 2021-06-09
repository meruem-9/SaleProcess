package se.kth.IV1350.Intergration;

import se.kth.IV1350.Model.Amount;

import java.util.Objects;

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
    @Override
    public String toString() {
        String builder = "item name: " + itemName + "\t" +
                "price: " + price + "\t" +
                "VAT: " + VAT + "\t";
        return builder;
    }

    /**
     * Two <code>ItemDTO</code> instances are equal if all fields are equal.
     *
     * @param obj The <code>ItemDTO</code> to compare with this <code>ItemDTO</code>.
     * @return <code>true</code> if all fields in the specified <code>ItemDTO</code> are equal to
     *         corresponding fields in this <code>ItemDTO</code>, <code>false</code> if they are not.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null){
            return false;
        }
        if (getClass() != obj.getClass()){
            return false;
        }
        final ItemDescription other = (ItemDescription) obj;
        if (!Objects.equals(this.price, other.price)){
            return false;
        }
        if (!this.itemName.equals(other.itemName)){
            return false;
        }
        if (!Objects.equals(this.VAT, other.VAT)){
            return false;
        }
        return true;
    }
}
