package se.kth.IV1350.Intergration;

public class EmployDiscount {

    public double discount;
    public final double DISCOUNT_PERCENTAGE = 1.0;

    public EmployDiscount(double discount){
        this.discount = discount;
    }
    
    public EmployDiscount(){
        this.discount = DISCOUNT_PERCENTAGE;
    }

    public double getDiscount(){
        return discount;
    }

}
