package se.kth.IV1350.Controller;

import se.kth.IV1350.Model.*;
import se.kth.IV1350.Intergration.*;

import java.util.ArrayList;
import java.util.List;


/**
 * The controller is the where the POS applications calls are all made
 * It includes startSale where a new sale is initiated. A method to register
 * items which consists of VAT rate. A final method pay to indicate an end
 * to the sale.
 */

public class Controller{
    private Sale sale;
    private Printer printer;
    private CashRegister cashRegister;
    private ItemInventory itemInventory;
    private EmployDiscount employDiscount;
    private InventorySystem inventorySystem;
    private AccountingSystem accountingSystem;
    private List<SaleObserver> saleObservers = new ArrayList<>();


    /**
     * Creating a new instance controller and adding parameters
     * @param systemStartup to access external systems
     * @param itemRegister to access the item catalog
     * @param printer to start up the printer
     */

    public Controller(SystemStartUp systemStartup, ItemRegister itemRegister, Printer printer) {
        this.inventorySystem = systemStartup.getInventorySystem();
        this.accountingSystem = systemStartup.getAccountingSystem();
        this.employDiscount = itemRegister.getEmployDiscount();
        this.printer = printer;
        this.cashRegister = new CashRegister();
        this.itemInventory = itemRegister.getItemInventory();
    }


        /**
         * Start new sale
         */
        public void initiateSale(){
            this.sale = new Sale();
            sale.addSaleObservers(saleObservers);
        }

        /**
         * checks if item is in POS inventory and adds it to sale
         * @param quantity to add the items needed
         * @param itemIdentifier to search for item
         * @returns the current bill of the current sale
         */

        public String registerNewItem(String itemIdentifier, Amount quantity)
                throws ItemNotInRegisterException, FailedOperationException {
            try {
                if (itemInventory.foundItem(itemIdentifier)) {
                    Item item = itemInventory.getItem(itemIdentifier, quantity);
                    return sale.findItem(item) + ", quantity" + quantity.toString();
                }}catch(InventoryDataFailureException dbFailure){
                throw new FailedOperationException("Failure to connect with the inventory", dbFailure);

            }
                return "Current bill " + displayTotalBill();


        }

        /**
         * displays total bill of sale
         */

        private String displayTotalBill(){
            return sale.getTotalBill().getTotalBill().toString();
        }

        /**
         * displays total bill including VAT of sale
         */


        public String displayTotalBillIncludingVAT(){
            return "Current bill with VAT calculated " + sale.getTotalBill().getTotalBillIncludingVAT().toString();
        }

        /**
         * takes payment in cash given with {@link Amount}.
         * Updates external accounting and inventory systems
         * takes
         * @param paidAmount
         * @returns the total change the customer should get
         */

        public String pay(Amount paidAmount){
            Cost cost = new Cost(paidAmount, sale.getTotalBill());
            cashRegister.addCost(cost);
            accountingSystem.accountingRegistry(sale);
            Receipt receipt = new Receipt(sale);
            printer.printReceipt(receipt);
            sale = null;
            return "Change : " + cost.getChange().toString();
        }

        public void addSaleObserver(SaleObserver saleObserver){
            saleObservers.add(saleObserver);
        }


    }



