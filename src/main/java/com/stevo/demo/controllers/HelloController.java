package com.stevo.demo.controllers;

import com.stevo.demo.utils.MyUtils;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String hello(Model model) {

        Object[] urls = {
                "http://below18.example.com",
                "http://above18.example.com"
        };

        model.addAttribute("name", MyUtils.getMessage("text", "http://below18.example.com",
                "http://above18.example.com", LocaleContextHolder.getLocale()));
        return "hello";
    }

    @RequestMapping("/hello/{id}")
    public String helloId(Model model,
                          @PathVariable("id") int id,
                          @RequestParam("name") String name) {

        model.addAttribute("id", id);
        model.addAttribute("name", name);

        return "hello-id";
    }
}
