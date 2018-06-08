package com.stevo.demo.controllers;

import com.stevo.demo.mail.MailSender;
import com.stevo.demo.mail.MockMailSender;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailController {

    private MailSender mailSender = new MockMailSender();

    @RequestMapping("/mail")
    public String hello() {

        mailSender.send("mail@example.com", "Test mail", "Body of the mail");

        return "Mail sent";
    }
}
