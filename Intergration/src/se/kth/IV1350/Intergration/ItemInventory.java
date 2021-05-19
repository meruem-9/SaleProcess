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

    public Item getItem(String itemIdentifier, Amount quantity){
        if(foundItem(itemIdentifier)) {
            return new Item(itemList.get(itemIdentifier), itemIdentifier, quantity);
        }
        return null;
    }


    private void addItems(){

        itemList.put("T-shirt", new ItemDescription(new Amount(199), "T-shirt", new Amount(199)));
        itemList.put("Jeans", new ItemDescription(new Amount(450), "Jeans", new Amount(450)));
        itemList.put("Shoes", new ItemDescription(new Amount(500), "Shoes", new Amount(500)));

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

  /*  public Item getItemFromItemInventory(String itemID)
            throws ItemNotInRegisterException, InventoryDataFailureException{
        ItemIdentifier ID = new ItemIdentifier(itemID);
        if(ID.equals("something")){
                throw new InventoryDataFailureException("Item data failure");
            }if(itemList.containsKey(itemID)){
                return itemList.get(itemID);
            }else{
                throw new ItemNotInRegisterException(itemID);}
        } */


}
