package com.company;

public class NegativeTimeValueException extends RuntimeException {

    private String message = "Time value cannot be negative";
    public NegativeTimeValueException() {
        System.out.println(message);
    }

    public NegativeTimeValueException(String message) {
        System.out.println(this.message+" for "+message);
    }

    public NegativeTimeValueException(String message, Throwable cause) {
        super(message, cause);
    }

    public NegativeTimeValueException(Throwable cause) {
        super(cause);
    }
}
