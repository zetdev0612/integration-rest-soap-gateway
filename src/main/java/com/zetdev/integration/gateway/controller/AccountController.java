package com.zetdev.integration.gateway.controller;

import com.zetdev.integration.gateway.service.AccountService;
import com.zetdev.integration.gateway.soap.dto.GetAccountResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @GetMapping("/{accountNumber}")
    public GetAccountResponse getAccount(@PathVariable String accountNumber) {
        return accountService.getAccount(accountNumber);
    }
}
