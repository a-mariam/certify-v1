package ecommerce.example.certify_v1.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class securityLog {


    @RequestMapping("/")
    public String welcome () {
        return "welcome home";
    }
}
