package com.stevo.demo.controllers;

import com.stevo.demo.mail.MailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;

@RestController
public class MailController {

  private MailSender mailSender;

  @Autowired
  public MailController(MailSender smtp) {
    this.mailSender = smtp;
  }

  @RequestMapping("/mail")
  public String mail() throws MessagingException {

    mailSender.send("mail@example.com", "Test mail", "Body of the mail");

    return "Mail  sent";
  }
}
