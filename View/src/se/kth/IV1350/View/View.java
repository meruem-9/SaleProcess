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

        System.out.println("Welcome,\n Start new purchase");
        controller.iniateSale();
        System.out.println("Pick items");
        String out = controller.registerNewItem("Spinach", new Amount(20));
        System.out.println(out);
        out = controller.registerNewItem("Corn", new Amount(15));
        System.out.println(out);
        out = controller.registerNewItem("Basil", new Amount(15));
        System.out.println("Total bill including VAT");
        out = controller.displayTotalBillIncludingVAT();
        System.out.println(out);
        System.out.println("Payed amount");
        out = controller.pay(new Amount(200));
        System.out.println(out);
    }
}
