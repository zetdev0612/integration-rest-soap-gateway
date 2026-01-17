package com.zetdev.integration.gateway.soap.endpoint;

import com.zetdev.integration.gateway.soap.dto.GetAccountRequest;
import com.zetdev.integration.gateway.soap.dto.GetAccountResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class AccountSoapEndpoint {

    private static final String NAMESPACE_URI =
            "http://zetdev.com/integration/account";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetAccountRequest")
    @ResponsePayload
    public GetAccountResponse getAccount(
            @RequestPayload GetAccountRequest request) {

        // Simulación sistema legacy
        GetAccountResponse response = new GetAccountResponse();
        response.setAccountNumber(request.getAccountNumber());
        response.setBalance(2_500_000.0);
        response.setStatus("ACTIVE");

        return response;
    }
}
