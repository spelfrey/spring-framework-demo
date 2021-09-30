package com.stevo.demo.service;

import static com.stevo.demo.domain.User.Role.ADMIN;
import static com.stevo.demo.domain.User.Role.UNVERIFIED;

import com.stevo.demo.commands.UserCommand;
import com.stevo.demo.domain.User;
import com.stevo.demo.repositories.UserRepository;
import java.util.List;
import javax.annotation.PostConstruct;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userService")
public class UserServiceImpl implements UserService {

  @Value("${admin.email}")
  private String adminEmail;

  @Value("${admin.name}")
  private String adminName;

  @Value("${admin.password}")
  private String adminPassword;

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
  @Transactional
  public void afterApplicationReady(ApplicationReadyEvent applicationReadyEvent) {
    if (!userRepository.findByEmail(adminEmail).isPresent()) {
      User user = new User();
      user.setEmail(adminEmail);
      user.setName(adminName);
      user.setPassword(adminPassword);
      user.setRoles(List.of(ADMIN));
      userRepository.save(user);
    }
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
