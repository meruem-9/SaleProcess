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

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        addNewLine(builder);
        appendLine(builder, "----------RECEIPT----------");
        addLocalDate(builder);
        appendLine(builder, "Items: ");
        appendLine(builder, sale.toString());
        appendLine(builder, "------------END------------");
        return builder.toString();
    }

    private void addNewLine(StringBuilder builder){
        builder.append("\n");
    }

    private void appendLine(StringBuilder builder, String line){
        builder.append(line);
        addNewLine(builder);
    }

    private void addLocalDate(StringBuilder builder){
        LocalDateTime saleTime = LocalDateTime.now();
        appendLine(builder, "Sale time: " + saleTime.toLocalDate().toString());
    }


}
