package com.muhammad.personal.intern.model.dto.requests;

import com.muhammad.personal.intern.model.Institution;
import com.muhammad.personal.intern.model.Skill;
import com.muhammad.personal.intern.model.enums.Degree;
import java.util.Date;
import java.util.List;

public class AddStudentDto {
    private String firstName;
    private String lastName;
    private String email;
    private Date dob;
    private char gender;
    private String mobile;
    private List<Skill> skills;
    private Institution institution;
    private Degree degree;
    private boolean isApproved;
    private String imagePath;

    public AddStudentDto(String firstName, String lastName, String email, Date dob, char gender, String mobile,
                         List<Skill> skills, Institution institution, Degree degree, boolean isApproved,
                         String imagePath) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dob = dob;
        this.gender = gender;
        this.mobile = mobile;
        this.skills = skills;
        this.institution = institution;
        this.degree = degree;
        this.isApproved = isApproved;
        this.imagePath = imagePath;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public Institution getInstitution() {
        return institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }

    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    public boolean isApproved() {
        return isApproved;
    }

    public void setApproved(boolean approved) {
        isApproved = approved;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
