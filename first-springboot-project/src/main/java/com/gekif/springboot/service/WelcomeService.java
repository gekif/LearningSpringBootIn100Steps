package com.gekif.springboot.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class WelcomeService {

    @Value("${welcome.message}")
    private String welcomeMessage;

    public String retrieveWelcomeMessage() {
        return "Good Morning";
    }

    public String retrieveWelcomeMessageWithName(String name) {
        return "Good Morning " + name;
    }

    public String retrieveMessageFromPropertyFile() {
        return welcomeMessage;
    }
}