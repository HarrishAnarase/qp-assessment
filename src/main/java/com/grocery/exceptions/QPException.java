package com.grocery.exceptions;

/**
 * Customized parent exception class for all user defined exception in this application
 * @author Harrish Anarase
 * @since 2024
 * @version 1.0
 */
public class QPException extends RuntimeException{
    public QPException(String message) {
        super(message);

    }
}
