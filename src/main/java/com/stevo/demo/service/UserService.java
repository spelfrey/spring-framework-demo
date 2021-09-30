package com.stevo.demo.service;

import com.stevo.demo.commands.UserCommand;
import org.springframework.boot.context.event.ApplicationReadyEvent;

public interface UserService {

  void signup(UserCommand userCommand);

  void afterApplicationReady(ApplicationReadyEvent applicationReadyEvent);
}
