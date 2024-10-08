package com.nzhussup.javadatamanagementservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootController {

    @GetMapping("/")
    public String root() {
        return "Welcome to the Java Management Service!" + "\n" +
                "Author: Nurzhanat Zhussup";
    }
}
