package com.gekif.springboot.web.springbootfirstwebapplication.service;

import org.springframework.stereotype.Component;

// Spring Bean
@Component
public class LoginService {

    public boolean validateUser(String userid, String password) {

        //username: gekif, password: gekif
        return userid.equalsIgnoreCase("gekif")
                && password.equalsIgnoreCase("gekif");
    }
}
