package com.zetdev.integration.gateway.soap.dto;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(
        name = "GetAccountRequest",
        namespace = "http://zetdev.com/integration/account"
)
public class GetAccountRequest {
    @XmlElement
    private String accountNumber;
}

