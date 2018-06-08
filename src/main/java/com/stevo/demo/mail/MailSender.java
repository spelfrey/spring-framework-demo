package com.stevo.demo.mail;

public interface MailSender {

    void send(String to, String subject, String body);
}
