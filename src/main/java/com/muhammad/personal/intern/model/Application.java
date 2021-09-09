package com.muhammad.personal.intern.model;

import com.muhammad.personal.intern.model.enums.Status;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ManyToOne
    private Student applicant;
    @ManyToOne
    private Job job;
    private Status applicationStatus;
    @CreationTimestamp
    private LocalDateTime regDate;
    @UpdateTimestamp
    public LocalDateTime dateLastModified;

    protected Application(){}

    public Application(Student applicant, Job job, Status applicationStatus) {
        this.applicant = applicant;
        this.job = job;
        this.applicationStatus = applicationStatus;
    }

    public long getId() {
        return id;
    }

    public Student getApplicant() {
        return applicant;
    }

    public void setApplicant(Student applicant) {
        this.applicant = applicant;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public Status getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(Status applicationStatus) {
        this.applicationStatus = applicationStatus;
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
