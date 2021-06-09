package se.kth.IV1350.Test;

import se.kth.IV1350.Intergration.Item;
import se.kth.IV1350.Intergration.ItemDescription;
import se.kth.IV1350.Model.Amount;
import se.kth.IV1350.Model.Sale;

import static org.junit.jupiter.api.Assertions.*;

class SaleTest {

    @org.junit.jupiter.api.Test
    void findItem() {
        Amount price = new Amount(450);
        Amount VAT = new Amount(20);
        String itemName = "Jeans";
        ItemDescription itemDescription = new ItemDescription(price, itemName, VAT);
        Amount quantity = new Amount(2);
        Item item = new Item(itemDescription, itemName, quantity);
        Sale sale = new Sale();
        String actualResult = sale.findItem(item);
        String expectedResult = item.getItemDescription().toString();
        assertEquals("The Strings are not equal.", expectedResult, actualResult);
    }


    @org.junit.jupiter.api.Test
    void testToString() {
        Amount price = new Amount(450);
        Amount VAT = new Amount(20);
        String itemNameAndIdentifier = "Jeans";
        ItemDescription itemDescription = new ItemDescription(price, itemNameAndIdentifier, VAT);
        Amount quantity = new Amount(1);
        Item item = new Item(itemDescription, itemNameAndIdentifier, quantity);
        Sale sale = new Sale();
        sale.findItem(item);
        String expectedResult = "Item name: " + itemNameAndIdentifier + "\t" +
                "price: " + price + "\t" +
                "VAT: " + VAT + "\t" +
                " quantity: " + quantity + "\nTotal bill: " + price + "\nVAT: " + VAT + "\n";
        String actualResult = sale.toString();
        assertEquals("Strings with the same entries are not the same.", expectedResult, actualResult);
    }
}