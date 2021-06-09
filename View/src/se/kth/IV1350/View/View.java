package se.kth.IV1350.View;

import se.kth.IV1350.Controller.*;
import se.kth.IV1350.Model.*;

public class View {

    private Controller controller;

    /**
     * creating a new instance representing the view
     * which is what the display would show to the
     * customer or cashier with the
     * @param controller where all the calls are made
     */

    public View(Controller controller){
        this.controller = controller;
    }

    /**
     * This is supposed to be a pseudo implementation of the
     * outputs made by the application
     */

    public void pseudoImplementation(){

        System.out.println("Welcome,\nStart new purchase");
        controller.initiateSale();
        System.out.println("Choose items");
        String out = controller.registerNewItem("T-shirt", new Amount(10));
        System.out.println(out);
        out = controller.registerNewItem("Jeans", new Amount(10));
        System.out.println(out);
        out = controller.registerNewItem("Shoes", new Amount(10));
        System.out.println(out);
        System.out.println("Total bill including VAT");
        out = controller.displayTotalBillIncludingVAT();
        System.out.println(out);
        System.out.println("Paid amount");
        out = controller.pay(new Amount(20000));
        System.out.println(out);
    }
}
