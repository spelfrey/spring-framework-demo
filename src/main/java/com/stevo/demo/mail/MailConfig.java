package com.stevo.demo.mail;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MailConfig {

    @Bean
    public MailSender mockMailSender() {
        return new MockMailSender();
    }

    @Bean
    public SmtpMailSender smtpMailSender() {
        return new SmtpMailSender();
    }

}
