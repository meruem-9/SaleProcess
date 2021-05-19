package se.kth.IV1350.Intergration;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.format.FormatStyle;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;




public class LogHandler {

    private static final String LOG_FILE_NAME = "POS sale log";
    private PrintWriter logFile;

    /**
     * creating an instance representing the loghandler
     *
     * @throws IOException
     */

    public LogHandler() throws IOException{
        logFile = new PrintWriter(new FileWriter(LOG_FILE_NAME), true);

    }

    /**
     * write in the log that an error occurred and saves the date and time
     *
     * @param exception to saved in the log
     */

    public void logException(Exception exception){

        StringBuilder logException = new StringBuilder();
        logException.append(showTime());
        logException.append("Error occurred: ");
        logException.append(exception.getMessage());
        logFile.println(logException);
        exception.printStackTrace(logFile);

    }

    private String showTime(){

        LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter formatDateAndTime = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        return currentTime.format(formatDateAndTime);
    }



}
