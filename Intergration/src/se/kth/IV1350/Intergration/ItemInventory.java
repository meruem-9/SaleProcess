package se.kth.IV1350.Intergration;

import se.kth.IV1350.Model.Amount;

import java.util.HashMap;

public class ItemInventory {

    private HashMap<String, ItemDescription>  itemList = new HashMap<>();

    /**
     * creating an instance of ItemInventory which
     * should represent the POS item at hand
     */
    ItemInventory(){
        addItems();
    }

    /**
     * searches for specified item using item identifier
     *
     * @param itemIdentifier to search for the item
     * @param quantity the amount of items searched for
     * @return null
     */

    public Item getItem(String itemIdentifier, Amount quantity)
        throws ItemNotInRegisterException, InventoryDataFailureException {
            if (itemIdentifier.equals("leaf")) {
                throw new InventoryDataFailureException("Failure in the database");
            }
            if (foundItem(itemIdentifier)) {
                return new Item(itemList.get(itemIdentifier), itemIdentifier, quantity);
            }
            throw new ItemNotInRegisterException(itemIdentifier);

    }


    private void addItems(){

        itemList.put("T-shirt", new ItemDescription(new Amount(200), "T-shirt", new Amount(20)));
        itemList.put("Jeans", new ItemDescription(new Amount(450), "Jeans", new Amount(30)));
        itemList.put("Shoes", new ItemDescription(new Amount(500), "Shoes", new Amount(20)));

    }

    /**
     *
     * @param itemIdentifier to find specified item
     * @return <code>true</code> if item is found
     * otherwise <code>false</code>
     */

    public boolean foundItem(String itemIdentifier){
        return itemList.containsKey(itemIdentifier);
    }



}
