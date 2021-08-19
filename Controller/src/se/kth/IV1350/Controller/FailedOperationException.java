package se.kth.IV1350.Controller;

public class FailedOperationException extends Exception{
    public FailedOperationException(String message, Exception exception){
        super(message, exception);
    }

}
