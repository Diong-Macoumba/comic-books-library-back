package com.monsoko.training.springboot.comicbookslibrary.exception;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException() {
        this(null,null);
    }

    public ResourceNotFoundException(final String message) {
        super(message, null);
    }

    public ResourceNotFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }

}
