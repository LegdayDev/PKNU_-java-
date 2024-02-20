package ch11.sec06;

public class InsufficientException extends Exception{
    public InsufficientException() {
        super();
    }

    public InsufficientException(String message) {
        super(message);
    }
}
