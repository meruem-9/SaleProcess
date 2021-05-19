package se.kth.IV1350.Model;

/**
 *  cash register, mimicking where the cash is stored
 */

public class CashRegister {

    private Amount balance;

    /**
     * creating an instance representing a cash register
     * with a balance 0
     */

    public CashRegister(){
        this.balance = new Amount(0);
    }

    /**
     * get the value of balance
     * @return the value of balance
     */

    public Amount getBalance(){
        return balance;
    }

    /**
     * a method representing the amount of cash that
     * should be added to the cash register depending on the cost
     *
     * @param cost the amount the will be added to the cash register
     */

    public void addCost(Cost cost){

        balance = balance.add(cost.getTotalBill().getTotalBillIncludingVAT());

    }
}
