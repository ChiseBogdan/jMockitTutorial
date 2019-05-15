package controller;

public class TheftException extends Exception {

    public TheftException(String msg) {
        super(msg);
    }

    public TheftException(String message,Throwable cause){
        super(message,cause);
    }
}
