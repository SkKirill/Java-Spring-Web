package com.flower.exception;

public class FlowerNotFoundException extends RuntimeException {
    public FlowerNotFoundException(String message) {
        super(message);
    }
}
