package com.mfschool.spring.si;

import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Component;

@Component
public class JmsHandler {
    @ServiceActivator
    public void handleMessage(String message) {
        System.out.println("Received message: " + message);
    }
}
