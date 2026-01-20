package com.zetdev.integration.gateway.controller;


import com.zetdev.integration.gateway.soap.dto.StatusResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class StatusController {

    @GetMapping("/status")
    public StatusResponse getStatus() {
        return new StatusResponse(
                "integration-rest-soap-gateway",
                "UP",
                "AVAILABLE"
        );
    }
}
