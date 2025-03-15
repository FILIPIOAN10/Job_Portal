package com.Ioan.jobportal.entity;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {"userId", "job"})
})
public class JobSeekerApply implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "userId", referencedColumnName = "user_account_id")
    private JobSeekerProfile userId;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "job", referencedColumnName = "jobPostId")
    private JobPostActivity job;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date applyDate;

    private String coverLetter;

    public JobSeekerApply() {
    }

    public JobSeekerApply(Integer id, JobSeekerProfile jobSeekerProfile, JobPostActivity job, Date applyDate, String coverLetter) {
        this.id = id;
        this.userId = jobSeekerProfile;
        this.job = job;
        this.applyDate = applyDate;
        this.coverLetter = coverLetter;
    }

    public Integer getId() {
        return id;
    }

    public JobSeekerApply setId(Integer id) {
        this.id = id;
        return this;
    }

    public JobSeekerProfile getUserId() {
        return userId;
    }

    public JobSeekerApply setUserId(JobSeekerProfile userId) {
        this.userId = userId;
        return this;
    }

    public JobPostActivity getJob() {
        return job;
    }

    public JobSeekerApply setJob(JobPostActivity job) {
        this.job = job;
        return this;
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public JobSeekerApply setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
        return this;
    }

    public String getCoverLetter() {
        return coverLetter;
    }

    public JobSeekerApply setCoverLetter(String coverLetter) {
        this.coverLetter = coverLetter;
        return this;
    }

    @Override
    public String toString() {
        return "JobSeekerApply{" +
                "id=" + id +
                ", jobSeekerProfile=" + userId +
                ", job=" + job +
                ", applyDate=" + applyDate +
                ", coverLetter='" + coverLetter + '\'' +
                '}';
    }
}
