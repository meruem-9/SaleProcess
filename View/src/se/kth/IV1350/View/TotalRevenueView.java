package se.kth.IV1350.View;

import se.kth.IV1350.Model.*;

/**
 * A class that implements a way to follow up of the
 * amount that has been paid
 */

public class TotalRevenueView {

    private Amount totalRevenue;

    /**
     * creating an instance representing the total revenue and
     * setting the amount to 0
     */

    public TotalRevenueView(){

        totalRevenue = new Amount(0);
    }

    /**
     * prints the current revenue depending on the sales
     */

    private void printCurrentRevenue(){
        System.out.println("Current revenue summation");
        System.out.println(totalRevenue);
    }

    /**
     * adds a new amount to current total revenue
     * @param amount the of specified sale
     */

    private void addNewPayment(Amount amount){

        totalRevenue = totalRevenue.add(amount);

    }


}
