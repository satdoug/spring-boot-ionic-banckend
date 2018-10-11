package com.douglassantos.cursomc.services.exceptions;

public class DataIntegrityServiceException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public DataIntegrityServiceException(String msg) {
        super(msg);
    }

    public DataIntegrityServiceException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
