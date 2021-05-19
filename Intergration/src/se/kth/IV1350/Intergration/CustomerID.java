package se.kth.IV1350.Intergration;

/**
 * a class representing the identification of customer
 */

public class CustomerID {
    private String customerMembershipNumber;

    /**
     * creating an instance of customer ID
     */

    public CustomerID(String customerMembershipNumber){

        this.customerMembershipNumber = customerMembershipNumber;
    }

    public String getCustomerMembershipNumber(){
        return customerMembershipNumber;
    }

}
