package se.kth.IV1350.Model;

import java.util.Objects;

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

    @Override
    public String toString() {
        return Integer.toString(amount);
    }

    /**
     * Checks if the specified amount is equal to this amount.
     *
     * @param obj The specified amount
     * @return <code>false</code> if it's not the same kind of object or class or
     * amount is not the same. <code>true</code> otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null){
            return false;
        }
        if (getClass() != obj.getClass()){
            return false;
        }
        final Amount other = (Amount) obj;
        if (!Objects.equals(this.amount, other.amount)){
            return false;
        }
        return true;
    }





}
