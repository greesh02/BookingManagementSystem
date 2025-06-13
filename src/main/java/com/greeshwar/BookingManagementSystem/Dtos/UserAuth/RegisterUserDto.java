package com.greeshwar.BookingManagementSystem.Dtos.UserAuth;

import com.greeshwar.BookingManagementSystem.Enums.Role;

import java.util.List;

public class RegisterUserDto {
    private String email;
    private String password;
    private String username;
    private List<String> roles;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
