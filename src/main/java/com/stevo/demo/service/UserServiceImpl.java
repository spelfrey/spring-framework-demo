package com.stevo.demo.service;

import com.stevo.demo.commands.UserCommand;
import com.stevo.demo.domain.User;
import com.stevo.demo.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

  private UserRepository userRepository;

  public UserServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public void signup(UserCommand userCommand) {
    User user = new User();
    user.setEmail(userCommand.getEmail());
    user.setName(userCommand.getName());
    user.setPassword(userCommand.getPassword());
    userRepository.save(user);
  }
}
