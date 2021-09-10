package com.muhammad.personal.intern.model;

import com.muhammad.personal.intern.model.enums.Status;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "jobs")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String title;
    @ManyToMany
    @JoinTable(
            name = "job_skill",
            joinColumns = @JoinColumn(name = "job_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id")
    )
    private List<Skill> skillSet;
    @ManyToOne(fetch = FetchType.LAZY)
    private Company company;
    private String jobCriteria;
    private String jobDescription;
    private int numOfCandidatesRequired;
    @ManyToOne
    private User recruiter;
    private Status status;
    private Date applicationEndDate;
    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name="job_applicants",
            joinColumns = @JoinColumn(name = "job_id"),
            inverseJoinColumns = @JoinColumn(name = "application_id")
    )
    private List<Application> applicants;
    @CreationTimestamp
    private LocalDateTime creationDate;
    @UpdateTimestamp
    public LocalDateTime dateLastModified;

    protected Job(){}

    public Job(String title, List<Skill> skillSet, Company company, String jobCriteria, String jobDescription,
               int numOfCandidatesRequired,User recruiter, Status status,
               Date applicationEndDate, List<Application> applicants) {
        this.title = title;
        this.skillSet = skillSet;
        this.company = company;
        this.jobCriteria = jobCriteria;
        this.jobDescription = jobDescription;
        this.numOfCandidatesRequired = numOfCandidatesRequired;
        this.recruiter = recruiter;
        this.status = status;
        this.applicationEndDate = applicationEndDate;
        this.applicants = applicants;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Skill> getSkillSet() {
        return skillSet;
    }

    public void setSkillSet(List<Skill> skillSet) {
        this.skillSet = skillSet;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getJobCriteria() {
        return jobCriteria;
    }

    public void setJobCriteria(String jobCriteria) {
        this.jobCriteria = jobCriteria;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public int getNumOfCandidatesRequired() {
        return numOfCandidatesRequired;
    }

    public void setNumOfCandidatesRequired(int numOfCandidatesRequired) {
        this.numOfCandidatesRequired = numOfCandidatesRequired;
    }

    public User getRecruiter() {
        return recruiter;
    }

    public void setRecruiter(User recruiter) {
        this.recruiter = recruiter;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Date getApplicationEndDate() {
        return applicationEndDate;
    }

    public void setApplicationEndDate(Date applicationEndDate) {
        this.applicationEndDate = applicationEndDate;
    }

    public List<Application> getApplicants() {
        return applicants;
    }

    public void setApplicants(List<Application> applicants) {
        this.applicants = applicants;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDateTime getDateLastModified() {
        return dateLastModified;
    }

    public void setDateLastModified(LocalDateTime dateLastModified) {
        this.dateLastModified = dateLastModified;
    }
}
