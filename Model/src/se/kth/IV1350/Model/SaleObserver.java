package se.kth.IV1350.Model;

/**
 * simple observer interface
 */

public interface SaleObserver {

    void newPayment (Amount totalAmount);

}
