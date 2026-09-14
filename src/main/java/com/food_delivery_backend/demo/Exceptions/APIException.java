package com.food_delivery_backend.demo.Exceptions;

public class APIException extends RuntimeException {
    public APIException(String message) {
        super(message);
    }
}
