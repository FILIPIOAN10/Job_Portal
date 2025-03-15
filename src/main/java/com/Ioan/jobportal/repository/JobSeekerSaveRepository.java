package com.Ioan.jobportal.repository;

import com.Ioan.jobportal.entity.JobPostActivity;
import com.Ioan.jobportal.entity.JobSeekerApply;
import com.Ioan.jobportal.entity.JobSeekerProfile;
import com.Ioan.jobportal.entity.JobSeekerSave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface JobSeekerSaveRepository extends JpaRepository<JobSeekerSave,Integer> {

     List<JobSeekerSave> findByUserId(JobSeekerProfile userAccountId);
     List<JobSeekerSave> findByJob(JobPostActivity job);

}
