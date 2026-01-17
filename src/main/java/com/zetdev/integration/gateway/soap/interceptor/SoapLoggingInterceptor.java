package com.zetdev.integration.gateway.soap.interceptor;

import org.jspecify.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.WebServiceClientException;
import org.springframework.ws.client.support.interceptor.ClientInterceptor;
import org.springframework.ws.context.MessageContext;
import org.springframework.ws.soap.SoapMessage;

import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;

public class SoapLoggingInterceptor implements ClientInterceptor {

    private static final Logger log =
            LoggerFactory.getLogger(SoapLoggingInterceptor.class);

    @Override
    public boolean handleRequest(MessageContext messageContext) {
        log.info("SOAP REQUEST:");
        logSoapMessage(messageContext.getRequest());
        messageContext.setProperty("startTime", System.currentTimeMillis());
        return true;
    }

    @Override
    public boolean handleResponse(MessageContext messageContext) {
        long start = (long) messageContext.getProperty("startTime");
        long duration = System.currentTimeMillis() - start;

        log.info("SOAP RESPONSE ({} ms):", duration);
        logSoapMessage(messageContext.getResponse());
        return true;
    }

    @Override
    public boolean handleFault(MessageContext messageContext) {
        log.error("SOAP FAULT:");
        logSoapMessage(messageContext.getResponse());
        return true;
    }

    @Override
    public void afterCompletion(MessageContext messageContext, @Nullable Exception ex) throws WebServiceClientException {
        // No se necesita implementación adicional aquí
    }

    private void logSoapMessage(Object message) {
        try {
            SoapMessage soapMessage = (SoapMessage) message;
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            soapMessage.writeTo(out);
            log.info(out.toString(StandardCharsets.UTF_8));
        } catch (Exception e) {
            log.error("Error logging SOAP message", e);
        }
    }
}
