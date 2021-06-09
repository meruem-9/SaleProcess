package se.kth.IV1350.Intergration;

import se.kth.IV1350.Model.Sale;

import java.time.LocalDateTime;
import java.util.HashMap;

public class AccountingSystem {
    private HashMap<LocalDateTime, Sale> accounting = new HashMap<>();

    /**
     * creating an instance accounting system
     */

    AccountingSystem(){

    }

    /**
     * adds time and date to external accounting system
     * @param sale for the finished sale
     */
    public void accountingRegistry(Sale sale){
        LocalDateTime saleTime = LocalDateTime.now();
        accounting.put(saleTime, sale);
    }
}
