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
    private User performer;// use company to distinguish at frontend
    @OneToOne
    private User approvedBy;
    @CreationTimestamp
    private LocalDateTime regDate;
    @UpdateTimestamp
    public LocalDateTime dateLastModified;

    protected Notification(){}

    public Notification(Request requestType, User performer) {
        this.requestType = requestType;
        this.performer = performer;
    }

    public Notification(Request requestType, User user, User approvedBy) {
        this.requestType = requestType;
        this.performer = user;
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

    public User getPerformer() {
        return performer;
    }

    public void setPerformer(User user) {
        this.performer = user;
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
