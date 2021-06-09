package se.kth.IV1350.Test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.IV1350.Intergration.Item;
import se.kth.IV1350.Intergration.ItemDescription;
import se.kth.IV1350.Model.Amount;
import se.kth.IV1350.Model.Receipt;
import se.kth.IV1350.Model.Sale;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;

class ReceiptTest {


    @Test
    void testToString() {
        Amount price = new Amount(450);
        Amount VAT = new Amount(20);
        String itemName = "Jeans";
        ItemDescription itemDescription = new ItemDescription(price, itemName, VAT);
        Amount quantity = new Amount(1);
        Item item = new Item(itemDescription, itemName, quantity);
        Sale sale = new Sale();
        sale.findItem(item);
        Receipt receipt = new Receipt(sale);
        LocalDateTime saleTime = LocalDateTime.now();
        String expectedResult = "\n----------RECEIPT----------" +
                "\nSale time: " + saleTime.toLocalDate().toString() +
                "\nItems: " +
                "\nitem name: " + itemName + "\t" +
                "price: " + price + "\t" +
                "VAT: " + VAT + "\t" +
                " quantity: " + quantity + "\nTotal bill: " + price + "\nVAT: " + VAT + "\n" +
                "\n------------END------------\n";
        String actualResult = receipt.toString();
        assertEquals("Receipt string is not equal to another instance with same state.", expectedResult, actualResult);
    }
}