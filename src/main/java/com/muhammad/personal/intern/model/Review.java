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
    @CreationTimestamp
    private LocalDateTime regDate;
    @UpdateTimestamp
    public LocalDateTime dateLastModified;

    protected Review(){}

    public Review(String msg, Job reviewedJob, boolean like) {
        this.msg = msg;
        this.reviewedJob = reviewedJob;
        this.likes = like;
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

    public boolean isLike() {
        return likes;
    }

    public void setLike(boolean like) {
        this.likes = like;
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
