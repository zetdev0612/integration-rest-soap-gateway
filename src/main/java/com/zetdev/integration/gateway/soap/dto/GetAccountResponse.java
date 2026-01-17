package com.zetdev.integration.gateway.soap.dto;

import jakarta.xml.bind.annotation.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(
        name = "GetAccountResponse",
        namespace = "http://zetdev.com/integration/account"
)
public class GetAccountResponse {
    private String accountNumber;
    private Double balance;
    private String status;
}

