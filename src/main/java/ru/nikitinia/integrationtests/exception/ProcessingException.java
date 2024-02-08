package ru.nikitinia.integrationtests.exception;

public class ProcessingException extends RuntimeException{

    public ProcessingException(String message) {
        super(message);
    }
}
