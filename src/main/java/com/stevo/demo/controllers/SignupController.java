package com.stevo.demo.controllers;

import com.stevo.demo.utils.MyUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
