package com.adeprogramming.universalpetcare.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
       super (message);
    }
}
