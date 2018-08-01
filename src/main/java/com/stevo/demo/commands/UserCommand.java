package com.stevo.demo.commands;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserCommand {

    @NotBlank @Email @Size(min = 4, max = 255) private String email;
    @NotBlank @Size(min = 1, max = 100) private String name;
    @NotBlank @Size(min = 6, max = 32) private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
