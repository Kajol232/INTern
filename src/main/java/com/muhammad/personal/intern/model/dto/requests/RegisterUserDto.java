package com.muhammad.personal.intern.model.dto.requests;

import com.muhammad.personal.intern.validator.ValidPassword;

public class RegisterUserDto {
    private String email;
    @ValidPassword
    private String password;
    private String confirmPassword;
    private boolean emailNotification;
    private String title;
    private String username;

    public RegisterUserDto(String email, String password, String confirmPassword, boolean emailNotification,
                           String title, String username) {

        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.emailNotification = emailNotification;
        this.title = title;
        this.username = username;
    }

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

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public boolean isEmailNotification() {
        return emailNotification;
    }

    public void setEmailNotification(boolean emailNotification) {
        this.emailNotification = emailNotification;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
