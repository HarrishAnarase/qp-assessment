package com.grocery.exceptions;

/**
 * Exception to be thrown if grocery item not available in database
 * @author Harrish Anarase
 * @since 2024
 * @version 1.0
 */
public class QPGroceryNotFoundException extends QPException {

    public QPGroceryNotFoundException(String message) {
        super(message);
    }
}
