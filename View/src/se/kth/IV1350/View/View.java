package se.kth.IV1350.View;

import se.kth.IV1350.Controller.*;
import se.kth.IV1350.Intergration.InventoryDataFailureException;
import se.kth.IV1350.Intergration.ItemNotInRegisterException;
import se.kth.IV1350.Intergration.LogHandler;
import se.kth.IV1350.Model.*;

import java.io.IOException;

public class View {

    private Controller controller;
    private ErrorMessageHandler errorMessageHandler = new ErrorMessageHandler();
    private LogHandler logHandler;

    /**
     * creating a new instance representing the view
     * which is what the display would show to the
     * customer or cashier with the
     * @param controller where all the calls are made
     */

    public View(Controller controller)throws IOException {
        this.controller = controller;
        controller.addSaleObserver(new TotalRevenueView());
        this.logHandler = new LogHandler();
    }

    /**
     * This is supposed to be a pseudo implementation of the
     * outputs made by the application
     */

    public void pseudoImplementation() {

        try {

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
        }catch(ItemNotInRegisterException exception){
            System.out.println("Unidentified item " + exception.getItemNotIdentified());
        }catch(FailedOperationException exception){
            manageExceptions("Item not registered", exception);
        }
    }

    private void manageExceptions(String message, Exception exception){
        errorMessageHandler.displayErrorMessage(message);
        logHandler.logException(exception);
    }


}
