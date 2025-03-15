package com.Ioan.jobportal.services;

import com.Ioan.jobportal.entity.JobPostActivity;
import com.Ioan.jobportal.entity.JobSeekerApply;
import com.Ioan.jobportal.entity.JobSeekerProfile;
import com.Ioan.jobportal.repository.JobSeekerApplyRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class JobSeekerApplyService {
    private final JobSeekerApplyRepository jobSeekerApplyRepository;

    public JobSeekerApplyService(JobSeekerApplyRepository jobSeekerApplyRepository) {
        this.jobSeekerApplyRepository = jobSeekerApplyRepository;
    }

    public List<JobSeekerApply> getCandidatesJobs(JobSeekerProfile userAccountId){
        return jobSeekerApplyRepository.findByUserId(userAccountId);
    }



    public List<JobSeekerApply> getJobCandidates(JobPostActivity job){
        return  jobSeekerApplyRepository.findByJob(job);
    }
    public void addNew(JobSeekerApply jobSeekerApply) {
         jobSeekerApplyRepository.save(jobSeekerApply);
    }
}
