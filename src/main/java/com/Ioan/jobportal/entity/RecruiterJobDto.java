package com.Ioan.jobportal.entity;

public class RecruiterJobDto {

    private Long totalCandidates;

    private Integer jobPostId;
    private String jobTitle;
    private JobLocation jobLocationId;
    private JobCompany jobCompanyId;

    public RecruiterJobDto(Long totalCandidates, Integer jobPostId, String jobTitle, JobLocation jobLocationId, JobCompany jobCompanyId) {
        this.totalCandidates = totalCandidates;
        this.jobPostId = jobPostId;
        this.jobTitle = jobTitle;
        this.jobLocationId = jobLocationId;
        this.jobCompanyId = jobCompanyId;
    }

    public Long getTotalCandidates() {
        return totalCandidates;
    }

    public RecruiterJobDto setTotalCandidates(Long totalCandidates) {
        this.totalCandidates = totalCandidates;
        return this;
    }

    public Integer getJobPostId() {
        return jobPostId;
    }

    public RecruiterJobDto setJobPostId(Integer jobPostId) {
        this.jobPostId = jobPostId;
        return this;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public RecruiterJobDto setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
        return this;
    }

    public JobLocation getJobLocationId() {
        return jobLocationId;
    }

    public RecruiterJobDto setJobLocationId(JobLocation jobLocationId) {
        this.jobLocationId = jobLocationId;
        return this;
    }

    public JobCompany getJobCompanyId() {
        return jobCompanyId;
    }

    public RecruiterJobDto setJobCompanyId(JobCompany jobCompanyId) {
        this.jobCompanyId = jobCompanyId;
        return this;
    }
}
