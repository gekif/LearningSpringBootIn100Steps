package com.gekif.springboot.controller;

import com.gekif.springboot.configuration.BasicConfiguration;
import com.gekif.springboot.service.WelcomeService;
import org.apache.commons.text.WordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class WelcomeController {

    @Autowired
    private WelcomeService service;

    @Autowired
    private BasicConfiguration configuration;

    @GetMapping(value = "/welcome")
    public String welcome() {
        return service.retrieveWelcomeMessage();
    }

    @GetMapping(value = "/welcome/{name}")
    public String welcomeWithName(@PathVariable String name) {
        String properName = WordUtils.capitalizeFully(name);
        return service.retrieveWelcomeMessageWithName(properName);
    }

    @GetMapping(value = "/welcome-message-property")
    public String welcomeFromMessageProperty() {
        return service.retrieveMessageFromPropertyFile();
    }

    @GetMapping(value = "/dynamic-configuration")
    public Map dynamicConfiguration() {
        Map map = new HashMap();
        map.put("message", configuration.getMessage());
        map.put("number", configuration.getNumber());
        map.put("value", configuration.isValue());

        return map;
    }

}