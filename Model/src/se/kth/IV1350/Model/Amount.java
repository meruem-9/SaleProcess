package se.kth.IV1350.Model;



public class Amount {

    private final int amount;

    /**
     * creating a constructor to represent the amount
     * with a parameter
     *
     * @param amount
     */

    public Amount(int amount) {
        this.amount = amount;
    }

    /**
     * get the value of amount and returns the value
     * @return amount
     */

    public int getAmount() {
        return amount;
    }

    public Amount subtract(Amount other) {
        return new Amount(amount - other.amount);
    }

    public Amount add(Amount other) { return new Amount(amount + other.amount); }

    public Amount multiply(Amount other){return new Amount(amount * other.amount );}





}
