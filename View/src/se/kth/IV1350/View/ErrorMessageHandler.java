package se.kth.IV1350.View;

import java.time.format.FormatStyle;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class ErrorMessageHandler {

    /**
     * a method to print the error message onto the
     * display
     * @param message the message to be displayed
     */

    void displayErrorMessage(String message){

        StringBuilder errorMessage = new StringBuilder();
        errorMessage.append("Error " + " || ");
        errorMessage.append(showTime());
        errorMessage.append(" || ");
        errorMessage.append(message);
        System.out.println(errorMessage);

    }

    private String showTime(){

        LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter formatDateAndTime = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        return currentTime.format(formatDateAndTime);
    }


}
