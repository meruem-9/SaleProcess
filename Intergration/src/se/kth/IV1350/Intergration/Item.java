package se.kth.IV1350.Intergration;

import se.kth.IV1350.Model.Amount;

public class Item {

    private ItemDescription itemDescription;
    private String itemIdentifier;
    private Amount quantity;

    /**
     * creating an instance representing item
     * @param itemDescription describes item
     * @param itemIdentifier identifies item
     * @param quantity of the amount items
     */

    public Item(ItemDescription itemDescription, String itemIdentifier, Amount quantity){

        this.itemDescription = itemDescription;
        this.itemIdentifier = itemIdentifier;
        this.quantity = quantity;

    }

    /**
     * gets item description
     * @return itemDescription
     */

    public ItemDescription getItemDescription(){
        return itemDescription;
    }

    /**
     * gets item identifier
     * @return itemIdentifier
     */

    public String getItemIdentifier(){
        return itemIdentifier;
    }

    /**
     * gets quantity
     * @return quantity
     */

    public Amount getQuantity(){
        return quantity;
    }



    public void decreaseQuantity(Amount itemQuantity){

        this.quantity = this.quantity.subtract(itemQuantity);
    }

    public void increaseQuantity(Amount itemQuantity){

        this.quantity = this.quantity.add(itemQuantity);
    }


}
