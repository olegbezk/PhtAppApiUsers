package com.photoapp.api.users.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private final Environment environment;

    @Autowired
    public UserController(Environment environment) {
        this.environment = environment;
    }

    @GetMapping("/status/check")
    public String status() {
        return "Working on the port: " + environment.getProperty("local.server.port");
    }
}
