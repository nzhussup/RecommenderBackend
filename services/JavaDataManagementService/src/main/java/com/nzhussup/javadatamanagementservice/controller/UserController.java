package com.nzhussup.javadatamanagementservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/users/")
    public String root() {
        return "Hello World In user";
    }


}
