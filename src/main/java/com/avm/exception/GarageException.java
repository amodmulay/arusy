package com.avm.exception;


/**
 * Exception class for duplicate vehicle registereation
 */
public class GarageException extends RuntimeException {

    public GarageException(final String format) {
        super(format);
    }
}