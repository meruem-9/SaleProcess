package se.kth.IV1350.Intergration;

import se.kth.IV1350.Model.*;

import java.util.*;

public class InventorySystem {

    private HashMap<String, Item> itemList = new HashMap();

    /**
     * creating an instance of inventory System
     */
    InventorySystem() {
        addItems();
    }

    /**
     * @param item searched item found
     * @return item when identified
     */
    private boolean itemFoundInInventory(Item item) {
        return itemList.containsKey(item.getItemIdentifier());
    }

    public void updateInventory(Sale sale) {
        HashMap<String, Item> items = sale.getItems();

        Set buying = items.entrySet();
        for (Object buy : buying) {
            Item item = getCurrentItem(buy);

            if (itemFoundInInventory(item)) {
                decrementItemQuantity(item);
            }
        }

    }

    private void decrementItemQuantity(Item item) {
        Item existingItem = itemList.get(item.getItemIdentifier());
        existingItem.decreaseQuantity(item.getQuantity());
        itemList.put(existingItem.getItemIdentifier(), existingItem);

    }

    private Item getCurrentItem(Object entry) {
        Map.Entry mapping = (Map.Entry) entry;
        return (Item) mapping.getValue();
    }

    private void addItems() {
        itemList.put("T-shirt", new Item(new ItemDescription(new Amount(199), "T-shirt", new Amount(199)), "T-shirt", new Amount(Integer.MAX_VALUE)));
        itemList.put("Jeans", new Item(new ItemDescription(new Amount(450), "Jeans", new Amount(450)), "Jeans", new Amount(Integer.MAX_VALUE)));
        itemList.put("Shoes", new Item(new ItemDescription(new Amount(500), "Shoes", new Amount(500)), "Shoes", new Amount(Integer.MAX_VALUE)));
    }

}
