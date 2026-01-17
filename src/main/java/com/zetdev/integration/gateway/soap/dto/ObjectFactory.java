package com.zetdev.integration.gateway.soap.dto;

import jakarta.xml.bind.annotation.XmlRegistry;

@XmlRegistry
public class ObjectFactory {

    public GetAccountResponse createGetAccountResponse() {
        return new GetAccountResponse();
    }

    public GetAccountRequest createGetAccountRequest() {
        return new GetAccountRequest();
    }
}