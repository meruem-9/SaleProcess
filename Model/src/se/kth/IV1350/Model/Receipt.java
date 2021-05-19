package se.kth.IV1350.Model;

import java.time.LocalDateTime;

public class Receipt {

    private Sale sale;

    /**
     * creating an instance sale
     */

    public Receipt(Sale sale){
        this.sale = sale;
    }

    private void assessLocalTimeAndDate(StringBuilder builder){
        LocalDateTime saleTime = LocalDateTime.now();
        appendLine(builder, "Sale Time: "+ saleTime.toLocalDate().toString());

    }

    private void appendLine(StringBuilder builder, String line){
        builder.append(line);
    }


}
