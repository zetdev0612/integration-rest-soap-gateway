package com.zetdev.integration.gateway.soap.client;

import com.zetdev.integration.gateway.exception.LegacySystemTimeoutException;
import com.zetdev.integration.gateway.exception.SoapIntegrationException;
import com.zetdev.integration.gateway.soap.dto.GetAccountRequest;
import com.zetdev.integration.gateway.soap.dto.GetAccountResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.WebServiceIOException;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.client.SoapFaultClientException;
import org.springframework.ws.soap.client.core.SoapActionCallback;

@Component
@RequiredArgsConstructor
public class AccountSoapClient {

    private final WebServiceTemplate webServiceTemplate;

    public GetAccountResponse getAccount(String accountNumber) {

        try {
            GetAccountRequest request = new GetAccountRequest();
            request.setAccountNumber(accountNumber);

            return (GetAccountResponse)
                    webServiceTemplate.marshalSendAndReceive(
                            request,
                            new SoapActionCallback(
                                    "http://zetdev.com/integration/account/GetAccountRequest"
                            )
                    );

        } catch (SoapFaultClientException e) {
            throw new SoapIntegrationException(
                    "Error funcional del sistema legacy SOAP", e);

        } catch (WebServiceIOException e) {
            throw new LegacySystemTimeoutException(
                    "Timeout al consumir el sistema legacy SOAP");

        } catch (Exception e) {
            throw new SoapIntegrationException(
                    "Error inesperado en integración SOAP", e);
        }
    }
}

