package com.stevo.demo.service;

import static com.stevo.demo.domain.User.Role.UNVERIFIED;

import com.stevo.demo.commands.UserCommand;
import com.stevo.demo.domain.User;
import com.stevo.demo.repositories.UserRepository;
import javax.annotation.PostConstruct;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userService")
public class UserServiceImpl implements UserService {

  private UserRepository userRepository;

  private static Log log = LogFactory.getLog(UserServiceImpl.class);

  public UserServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @PostConstruct
  public void init() {
    log.info("Inside PostConstructor");
  }

  @Override
  @EventListener
  public void afterApplicationReady(ApplicationReadyEvent applicationReadyEvent) {
    log.info("Inside afterApplicationReady");
  }

  @Override
  @Transactional
  public void signup(UserCommand userCommand) {
    User user = new User();
    user.setEmail(userCommand.getEmail());
    user.setName(userCommand.getName());
    user.setPassword(userCommand.getPassword());
    user.getRoles().add(UNVERIFIED);
    userRepository.save(user);
  }
}
