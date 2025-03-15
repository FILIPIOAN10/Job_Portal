package com.Ioan.jobportal.services;


import com.Ioan.jobportal.entity.JobPostActivity;
import com.Ioan.jobportal.entity.JobSeekerProfile;
import com.Ioan.jobportal.entity.JobSeekerSave;
import com.Ioan.jobportal.repository.JobSeekerSaveRepository;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Clasa `JobSeekerSaveService` gestionează logica de business pentru joburile
 * salvate de candidați.
 */
@Service
public class JobSeekerSaveService {

    private final JobSeekerSaveRepository jobSeekerSaveRepository;

    public JobSeekerSaveService(JobSeekerSaveRepository jobSeekerSaveRepository) {
        this.jobSeekerSaveRepository = jobSeekerSaveRepository;
    }

    public List<JobSeekerSave> getCandidatesJobs(JobSeekerProfile userAccountId){
        return jobSeekerSaveRepository.findByUserId(userAccountId);
    }

    public List<JobSeekerSave> getJobCanditates(JobPostActivity job) {
        return jobSeekerSaveRepository.findByJob(job);
    }


    public void addNew(JobSeekerSave jobSeekerSave) {
        jobSeekerSaveRepository.save(jobSeekerSave);
    }

}
