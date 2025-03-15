package com.Ioan.jobportal.entity;


import jakarta.persistence.*;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
public class JobPostActivity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer jobPostId;

    @ManyToOne
    @JoinColumn(name = "postedById",referencedColumnName = "userId")
    private Users postedById;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "jobLocationId", referencedColumnName = "Id")
    private JobLocation jobLocationId;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "jobCompanyId",referencedColumnName = "Id")
    private JobCompany jobCompanyId;

    @Transient
    private Boolean isActive;

    @Transient
    private Boolean isSaved;

    @Length(max = 10000)
    private String descriptionOfJob;

    private String jobType;

    private String salary;
    private String remote;


    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date postedDate;

    private String jobTitle;

    public JobPostActivity() {
    }

    public JobPostActivity(Integer jobPostId, Users postedById, JobLocation jobLocationId, JobCompany jobCompanyId, Boolean isActive, Boolean isSaved, String descriptionOfJob, String jobType, String salary, String remote, Date postedDate, String jobTitle) {
        this.jobPostId = jobPostId;
        this.postedById = postedById;
        this.jobLocationId = jobLocationId;
        this.jobCompanyId = jobCompanyId;
        this.isActive = isActive;
        this.isSaved = isSaved;
        this.descriptionOfJob = descriptionOfJob;
        this.jobType = jobType;
        this.salary = salary;
        this.remote = remote;
        this.postedDate = postedDate;
        this.jobTitle = jobTitle;
    }

    public Integer getJobPostId() {
        return jobPostId;
    }

    public JobPostActivity setJobPostId(Integer jobPostId) {
        this.jobPostId = jobPostId;
        return this;
    }

    public Users getPostedById() {
        return postedById;
    }

    public JobPostActivity setPostedById(Users postedById) {
        this.postedById = postedById;
        return this;
    }

    public JobLocation getJobLocationId() {
        return jobLocationId;
    }

    public JobPostActivity setJobLocationId(JobLocation jobLocationId) {
        this.jobLocationId = jobLocationId;
        return this;
    }

    public JobCompany getJobCompanyId() {
        return jobCompanyId;
    }

    public JobPostActivity setJobCompanyId(JobCompany jobCompanyId) {
        this.jobCompanyId = jobCompanyId;
        return this;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public JobPostActivity setIsActive(Boolean active) {
        isActive = active;
        return this;
    }

    public Boolean getIsSaved() {
        return isSaved;
    }

    public JobPostActivity setIsSaved(Boolean saved) {
        isSaved = saved;
        return this;
    }

    public String getDescriptionOfJob() {
        return descriptionOfJob;
    }

    public JobPostActivity setDescriptionOfJob(String descriptionOfJob) {
        this.descriptionOfJob = descriptionOfJob;
        return this;
    }

    public String getJobType() {
        return jobType;
    }

    public JobPostActivity setJobType(String jobType) {
        this.jobType = jobType;
        return this;
    }

    public String getSalary() {
        return salary;
    }

    public JobPostActivity setSalary(String salary) {
        this.salary = salary;
        return this;
    }

    public String getRemote() {
        return remote;
    }

    public JobPostActivity setRemote(String remote) {
        this.remote = remote;
        return this;
    }

    public Date getPostedDate() {
        return postedDate;
    }

    public JobPostActivity setPostedDate(Date postedDate) {
        this.postedDate = postedDate;
        return this;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public JobPostActivity setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
        return this;
    }

    @Override
    public String toString() {
        return "JobPostActivity{" +
                "jobPostId=" + jobPostId +
                ", postedById=" + postedById +
                ", jobLocationId=" + jobLocationId +
                ", jobCompanyId=" + jobCompanyId +
                ", isActive=" + isActive +
                ", isSaved=" + isSaved +
                ", descriptionOfJob='" + descriptionOfJob + '\'' +
                ", jobType='" + jobType + '\'' +
                ", salary='" + salary + '\'' +
                ", remote='" + remote + '\'' +
                ", postedDate=" + postedDate +
                ", jobTitle='" + jobTitle + '\'' +
                '}';
    }
}
