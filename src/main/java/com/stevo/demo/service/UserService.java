package com.stevo.demo.service;

import com.stevo.demo.commands.UserCommand;

public interface UserService {

  void signup(UserCommand userCommand);
}
