package com.grocery.exceptions;

/**
 * Exception to be thrown for invalid credentials
 * @author Harrish Anarase
 * @since 2024
 * @version 1.0
 */
public class QPInvalidCredentialsException extends QPException{
    public QPInvalidCredentialsException(String message) {
        super(message);
    }
}
