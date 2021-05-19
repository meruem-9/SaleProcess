package se.kth.IV1350.Intergration;

import se.kth.IV1350.Model.Receipt;

/**
 * this object represents a printer whos main duty is to
 * print a receipt
 */

public class Printer {

    /**
     * creating an instance Printer
     */

    public Printer(){

    }

    public void printReceipt(Receipt receipt){
        System.out.println(receipt);
    }
}
