package com.muhammad.personal.intern.model.dto.requests;

import com.muhammad.personal.intern.model.Company;

public class AddCompanyUserDto {
    private String email;
    private boolean emailNotification;
    private String title;
    private String username;
    private Company company;

    public AddCompanyUserDto(String email, boolean emailNotification, String title, String username, Company company) {
        this.email = email;
        this.emailNotification = emailNotification;
        this.title = title;
        this.username = username;
        this.company = company;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
