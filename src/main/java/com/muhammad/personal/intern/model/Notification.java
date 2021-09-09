package com.muhammad.personal.intern.model;

import com.muhammad.personal.intern.model.enums.Request;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private Request requestType;
    @OneToOne
    private User user;// use company to distinguish at frontend
    @OneToOne
    private User approvedBy;
    @CreationTimestamp
    private LocalDateTime regDate;
    @UpdateTimestamp
    public LocalDateTime dateLastModified;

    protected Notification(){}

    public Notification(Request requestType, User user, User approvedBy) {
        this.requestType = requestType;
        this.user = user;
        this.approvedBy = approvedBy;
    }

    public long getId() {
        return id;
    }

    public Request getRequestType() {
        return requestType;
    }

    public void setRequestType(Request requestType) {
        this.requestType = requestType;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(User approvedBy) {
        this.approvedBy = approvedBy;
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
