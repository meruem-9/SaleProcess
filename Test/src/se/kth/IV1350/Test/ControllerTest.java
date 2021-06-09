package se.kth.IV1350.Test;

import se.kth.IV1350.Controller.Controller;
import se.kth.IV1350.Intergration.ItemRegister;
import se.kth.IV1350.Intergration.Printer;
import se.kth.IV1350.Intergration.SystemStartUp;
import se.kth.IV1350.Model.Amount;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {
    private Controller controller;

    @org.junit.jupiter.api.BeforeEach
    public void setUp() {
        controller = new Controller(new SystemStartUp(), new ItemRegister(), new Printer());
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        controller = null;
    }

    @org.junit.jupiter.api.Test
    void initiateSale() {
        controller.initiateSale();
        String itemName = "T-shirt";
        Amount price = new Amount(200);
        Amount VAT = new Amount(20);
        String result = controller.registerNewItem(itemName, new Amount(1));
        String expectedResult = "item name:" + itemName + "\t" + "price: " + price + "\t" +
                " VAT: " + VAT + "\t" +
                ", quantity: " + new Amount(1) + ", current bill: " + price;
        assertEquals("String from registerNewItem is not the same desired item.", expectedResult, result );
    }


    @org.junit.jupiter.api.Test
    void displayTotalBillIncludingVAT() {
        controller.initiateSale();
        String itemName = "T-shirt";
        Amount price = new Amount(200);
        Amount VAT = new Amount(20);
        controller.registerNewItem(itemName, new Amount(1));
        String result = controller.displayTotalBillIncludingVAT();
        String expectedResult = "total bill including VAT: " + price.add(VAT);
        assertEquals("The total bill including VAT from the sale is not equal to the expected result.", expectedResult, result);

    }

    @org.junit.jupiter.api.Test
    void pay() {
        controller.initiateSale();
        String itemName = "T-shirt";
        Amount price = new Amount(200);
        Amount VAT = new Amount(20);
        controller.registerNewItem(itemName, new Amount(1));
        Amount paidAmount = new Amount(500);
        String expectedResult = "Change: " + paidAmount.subtract(price.add(VAT));
        String result = controller.pay(paidAmount);
        assertEquals("Change is not equal to change needed.", expectedResult, result);
    }
}