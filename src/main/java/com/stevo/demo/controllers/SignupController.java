package com.stevo.demo.controllers;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/signup")
public class SignupController {

    private static Log log = LogFactory.getLog(SignupController.class);

    @GetMapping
    public String signup() {

        log.info("GET SIGNUP");
        return "signup";
    }

    @PostMapping
    public String doSignup(@RequestParam("email") String email,
                           @RequestParam("name") String name,
                           @RequestParam("password") String password) {

        log.info("email: " + email + "; Name: " + name + "; Password: " + password);
        return "redirect:/";
    }
}
