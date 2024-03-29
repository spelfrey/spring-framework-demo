package com.stevo.demo.controllers;

import com.stevo.demo.commands.UserCommand;
import com.stevo.demo.service.UserService;
import com.stevo.demo.utils.MyUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "/signup")
public class SignupController {

  private static Log log = LogFactory.getLog(SignupController.class);

  private UserService userService;

  public SignupController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping
  public String signup(Model model) {

    model.addAttribute("userCommand", new UserCommand());
    log.info("GET SIGNUP");
    return "signup";
  }

  @PostMapping
  public String doSignup(
      @Validated UserCommand userCommand,
      BindingResult result,
      RedirectAttributes redirectAttributes) {

    if (result.hasErrors()) {
      log.info("Validation failed");
      return "signup";
    }

    userService.signup(userCommand);
    MyUtils.flash(redirectAttributes, "success", "signupSucess");
//    redirectAttributes.addFlashAttribute("flashMessage", "Signup Succeeded");
//    redirectAttributes.addFlashAttribute("flashKind", "success");
    log.info(
        "email: "
            + userCommand.getEmail()
            + "; Name: "
            + userCommand.getName()
            + "; Password: "
            + userCommand.getPassword());
    return "redirect:/";
  }
}
