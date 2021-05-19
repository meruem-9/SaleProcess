package se.kth.IV1350.Model;

import se.kth.IV1350.Intergration.*;

import java.lang.Math;


public class TotalBill {

    private Amount totalBill;
    private Amount totalVAT;

    /**
     * creating and instance of totalbill
     */

    public TotalBill() {
        this.totalBill = new Amount(0);
        this.totalVAT = new Amount(0);
    }

    /**
     * creating 2 methods that gets the value
     * of total bill and total VAT.
     *
     * @return the total bill
     * @return the total VAT rate
     */
    public Amount getTotalBill() {
        return totalBill;
    }

    public Amount getTotalVAT() {
        return totalVAT;
    }

    public Amount getTotalBillIncludingVAT() {
        return totalBill.add(totalVAT);
    }

    public void reviseTotalBill(Item item) {
        if (item == null) {
            return;
        }
        Amount totalItems = item.getQuantity();
        Amount priceOfItem = item.getItemDescription().getPrice();
        Amount VATRateOfItem = item.getItemDescription().getVAT();

        this.totalVAT = this.totalVAT.add(totalItems.multiply(VATRateOfItem));
        this.totalBill = this.totalBill.add(totalItems.multiply(priceOfItem));
    }
}
