package com.gekif.springboot.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserCommandLineRunner implements CommandLineRunner {


    @Override
    public void run(String... strings) throws Exception {
        System.out.println("UserCommandLineRunner");
    }
}
