package com.gekif.springboot.service;

import org.springframework.stereotype.Component;


@Component
public class WelcomeService {

    public String retrieveWelcomeMessage() {
        return "Good Morning";
    }

    public String retrieveWelcomeMessageWithName(String name) {
        return "Good Morning " + name;
    }
}