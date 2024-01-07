package com.grocery.exceptions;

/**
 * Exception to be thrown if user authentication/authorization fail
 * @author Harrish Anarase
 * @since 2024
 * @version 1.0
 */
public class UserNotFoundException extends QPException{
    public UserNotFoundException(String message) {
        super( message);
    }
}
