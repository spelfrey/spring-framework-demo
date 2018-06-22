package com.stevo.demo.mail;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class MailConfig {

    @Bean
    @Profile("dev")
    public MailSender mockMailSender() {
        return new MockMailSender();
    }

    @Bean
    @Profile("!dev")
    public SmtpMailSender smtpMailSender() {
        return new SmtpMailSender();
    }

}
