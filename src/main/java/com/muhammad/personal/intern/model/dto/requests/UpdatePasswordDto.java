package com.muhammad.personal.intern.model.dto.requests;

import com.muhammad.personal.intern.model.User;
import com.muhammad.personal.intern.validator.ValidPassword;

public class UpdatePasswordDto {
    private User user;
    private String oldPassword;
    @ValidPassword
    private String password;
    private String confirmPassword;


    public UpdatePasswordDto(User user, String oldPassword, String password, String confirmPassword) {
        this.user = user;
        this.oldPassword = oldPassword;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }
}
