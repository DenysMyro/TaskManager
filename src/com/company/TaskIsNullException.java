package com.company;

public class TaskIsNullException extends Throwable {

    public TaskIsNullException() {
    }

    public TaskIsNullException(String message) {
        super(message);
    }
}
