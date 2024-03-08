package ru.flamexander.spring.security.jwt.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class MainController {
    @GetMapping(path = "/unsecured")
    public String unsecuredData() {
        return "unsecured";
    }
    @GetMapping("/secured")
    public String securedData() {
        System.out.println("SDSADsad");
        return "secured";
    }

    @GetMapping("/admin")
    public String adminData() {
        return "Admin data";
    }
    @GetMapping("/authen")
    public String authData() {
        return "auth";
    }

    @GetMapping("/info")
    public String userData(Principal principal) {
        return principal.getName();
    }
}