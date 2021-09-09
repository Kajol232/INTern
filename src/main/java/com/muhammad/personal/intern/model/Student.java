package com.muhammad.personal.intern.model;

import com.muhammad.personal.intern.model.enums.Degree;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @OneToOne
    private User user;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String email;
    private Date dob;
    private char gender;
    private String mobile;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "student_skill",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id")
    )
    private List<Skill> skills;
    @ManyToOne
    private Institution institution;
    private Degree degree;
    @Column(length = 1024)
    private String imageUrl;
    @OneToMany
    private List<Review> reviews;
    private boolean isApproved;
    @CreationTimestamp
    public LocalDateTime dateCreated;
    @UpdateTimestamp
    public LocalDateTime dateLastModified;

    protected Student(){}

    public Student(User user, String firstName, String lastName, String email, Date dob, char gender, String mobile,
                   List<Skill> skills, Institution institution, Degree degree, String imageUrl, List<Review> reviews,
                   boolean isApproved) {
        this.user = user;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dob = dob;
        this.gender = gender;
        this.mobile = mobile;
        this.skills = skills;
        this.institution = institution;
        this.degree = degree;
        this.imageUrl = imageUrl;
        this.reviews = reviews;
        this.isApproved = isApproved;
    }

    public long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public String getImageUrl() {
        if(imageUrl == null){
            return null;
        }
        return  "src\\main\\resources\\static\\uploads\\" + getId() + "\\" + imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public boolean isApproved() {
        return isApproved;
    }

    public void setApproved(boolean approved) {
        isApproved = approved;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public LocalDateTime getDateLastModified() {
        return dateLastModified;
    }

    public void setDateLastModified(LocalDateTime dateLastModified) {
        this.dateLastModified = dateLastModified;
    }
}

