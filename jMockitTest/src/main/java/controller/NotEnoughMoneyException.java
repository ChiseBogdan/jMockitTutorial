package controller;

public class NotEnoughMoneyException extends Exception {

    public NotEnoughMoneyException(String msg) {
        super(msg);
    }

    public NotEnoughMoneyException(String message,Throwable cause){
        super(message,cause);
    }
}
