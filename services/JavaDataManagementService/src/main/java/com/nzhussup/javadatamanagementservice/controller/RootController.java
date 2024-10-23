package com.nzhussup.javadatamanagementservice.controller;

import com.nzhussup.javadatamanagementservice.model.User;
import com.nzhussup.javadatamanagementservice.security.UserPrincipal;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
public class RootController {

    @GetMapping("/")
    public String root() {
        return "Welcome to the Java Management Service!" + "\n" +
                "Author: Nurzhanat Zhussup";
    }

    @GetMapping("/public")
    public String publicRoot() {
        return "Public Root";
    }
}
