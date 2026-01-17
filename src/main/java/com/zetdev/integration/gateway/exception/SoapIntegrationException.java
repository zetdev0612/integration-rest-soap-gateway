package com.zetdev.integration.gateway.exception;

public class SoapIntegrationException extends RuntimeException {

    public SoapIntegrationException(String message) {
        super(message);
    }

    public SoapIntegrationException(String message, Throwable cause) {
        super(message, cause);
    }
}
