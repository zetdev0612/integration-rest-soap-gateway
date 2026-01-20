package com.zetdev.integration.gateway.soap.dto;

import java.time.LocalDateTime;

public class StatusResponse {

    private String service;
    private String status;
    private String soapDependency;
    private LocalDateTime timestamp;

    public StatusResponse(String service, String status, String soapDependency) {
        this.service = service;
        this.status = status;
        this.soapDependency = soapDependency;
        this.timestamp = LocalDateTime.now();
    }

    public String getService() {
        return service;
    }

    public String getStatus() {
        return status;
    }

    public String getSoapDependency() {
        return soapDependency;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
