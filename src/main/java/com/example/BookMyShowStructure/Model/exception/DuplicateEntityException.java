package com.example.BookMyShowStructure.Model.exception;

public class DuplicateEntityException extends RuntimeException{

    private final String message;

    public DuplicateEntityException(String message) {
        super(message);
        this.message = message;
    }
}
