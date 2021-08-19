package se.kth.IV1350.Model;

import se.kth.IV1350.Intergration.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Iterator;
import java.util.Set;

/**
 * to represent the sale in POS between cashier and customer
 */

public class Sale {
    private TotalBill totalBill;
    private HashMap<String, Item> items = new HashMap<>();
    private List<SaleObserver> saleObservers = new ArrayList<>();

    /**
     * creating a new instance representing sale
     */
    public Sale() {
        this.totalBill = new TotalBill();
    }

    /**
     * get hashmap items and
     *
     * @return items
     */

    public HashMap<String, Item> getItems() {
        return items;
    }

    /**
     * updates sale with a
     *
     * @param item that will be added to the sale and
     * @return itemdescription that describes item
     */


    public String findItem(Item item) {
        if (itemListConsistsOf(item)) {
            reviseItemQuantityAndTotalBill(item);
        } else
            addItemAndReviseTotalBill(item);

        return item.getItemDescription().toString();
    }


    private void reviseItemQuantityAndTotalBill(Item item) {
        Item existingItem = items.get(item.getItemIdentifier());
        existingItem.increaseQuantity(item.getQuantity());
        items.put(existingItem.getItemIdentifier(), existingItem);
        totalBill.reviseTotalBill(item);
        informObserver();
    }


    private void addItemAndReviseTotalBill(Item item) {
        items.put(item.getItemIdentifier(), item);
        totalBill.reviseTotalBill(item);
        informObserver();
    }


    private boolean itemListConsistsOf(Item item) {
        return items.containsKey(item.getItemIdentifier());
    }


    /**
     * get the value of totalBill
     * and returns the value.
     */

    public TotalBill getTotalBill() {
        return totalBill;
    }

    private void informObserver() {
        for (SaleObserver observer : saleObservers) {
            observer.newPayment(totalBill.getTotalBill());
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Iterator entriesIterator = getEntries();

        while (entriesIterator.hasNext()) {
            Item item = getCurrentItem(entriesIterator);
            builder.append(item.getItemDescription().toString());
            addNewLine(builder, " quantity: " + item.getQuantity().toString());
        }

        addNewLine(builder, "Total bill: " + totalBill.getTotalBill().toString());
        addNewLine(builder, "Total bill including VAT: " + totalBill.getTotalBillIncludingVAT());
        return builder.toString();
    }

    private Iterator getEntries() {
        Set entries = items.entrySet();
        return entries.iterator();
    }

    private Item getCurrentItem(Iterator entriesIterator) {
        Map.Entry mapping = (Map.Entry) entriesIterator.next();
        return (Item) mapping.getValue();
    }

    public void addSaleObservers(List<SaleObserver> observers){
        saleObservers.addAll(observers);
    }

    private void addNewLine(StringBuilder builder, String line) {
        builder.append(line);
        builder.append("\n");
    }
}
