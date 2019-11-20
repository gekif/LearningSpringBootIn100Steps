package com.gekif.springboot.controller;

import com.gekif.springboot.service.WelcomeService;
import org.apache.commons.text.WordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class WelcomeController {

    @Autowired
    private WelcomeService service;

    @GetMapping(value = "/welcome")
    public String welcome() {
        return service.retrieveWelcomeMessage();
    }

    @GetMapping(value = "/welcome/{name}")
    public String welcomeWithName(@PathVariable String name) {
        String properName = WordUtils.capitalizeFully(name);
        return service.retrieveWelcomeMessageWithName(properName);
    }
}