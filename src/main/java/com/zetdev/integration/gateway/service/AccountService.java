package com.zetdev.integration.gateway.service;

import com.zetdev.integration.gateway.soap.client.AccountSoapClient;
import com.zetdev.integration.gateway.soap.dto.GetAccountResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountSoapClient soapClient;

    public GetAccountResponse getAccount(String accountNumber) {
        return soapClient.getAccount(accountNumber);
    }
}
