package com.muhammad.personal.intern.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "user_reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String msg;
    @ManyToOne
    private Job reviewedJob;
    private boolean likes;
    @ManyToOne
    private Company company;
    @ManyToOne
    private Student student;
    @OneToOne
    private User reviewer;
    @CreationTimestamp
    private LocalDateTime regDate;
    @UpdateTimestamp
    public LocalDateTime dateLastModified;

    protected Review(){}

    public Review(String msg, Job reviewedJob, boolean like, Company company,  User reviewer) {
        this.msg = msg;
        this.reviewedJob = reviewedJob;
        this.likes = like;
        this.company = company;
        this.reviewer = reviewer;
    }
    public Review(String msg, Job reviewedJob, boolean like,Student student, User reviewer) {
        this.msg = msg;
        this.reviewedJob = reviewedJob;
        this.likes = like;
        this.student = student;
        this.reviewer = reviewer;
    }

    public long getId() {
        return id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Job getReviewedJob() {
        return reviewedJob;
    }

    public void setReviewedJob(Job reviewedJob) {
        this.reviewedJob = reviewedJob;
    }

    public boolean isLikes() {
        return likes;
    }

    public void setLikes(boolean likes) {
        this.likes = likes;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public LocalDateTime getRegDate() {
        return regDate;
    }

    public void setRegDate(LocalDateTime regDate) {
        this.regDate = regDate;
    }

    public LocalDateTime getDateLastModified() {
        return dateLastModified;
    }

    public void setDateLastModified(LocalDateTime dateLastModified) {
        this.dateLastModified = dateLastModified;
    }
}
