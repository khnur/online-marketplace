package com.example.springBoot21.exceptions;

public class ItemNotExistsException extends RuntimeException {
    public ItemNotExistsException(String message) {
        super(message);
    }
}
