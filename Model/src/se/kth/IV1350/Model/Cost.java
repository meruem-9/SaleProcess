package se.kth.IV1350.Model;



public class Cost {

    private Amount givenAmount;
    private TotalBill totalBill;

    /**
     * creating an instance representing the Cost
     * with the
     * @param givenAmount which is the bill the customer has paid
     * @param totalBill which is what the customer is charged
     */
    public Cost(Amount givenAmount, TotalBill totalBill){
        this.givenAmount = givenAmount;
        this.totalBill = totalBill;
    }

    /**
     * get the total bill
     * @return the total bill
     */

    TotalBill getTotalBill(){
        return totalBill;
    }

    /**
     * Should calculate the change and
     * @return the total change
     */

    public Amount getChange() {
        return givenAmount.subtract(totalBill.getTotalBillIncludingVAT());
    }
}
