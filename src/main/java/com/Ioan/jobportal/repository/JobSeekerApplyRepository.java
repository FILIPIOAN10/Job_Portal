package com.Ioan.jobportal.repository;

import com.Ioan.jobportal.entity.JobPostActivity;
import com.Ioan.jobportal.entity.JobSeekerApply;
import com.Ioan.jobportal.entity.JobSeekerProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobSeekerApplyRepository extends JpaRepository<JobSeekerApply, Integer> {

    List<JobSeekerApply> findByUserId(JobSeekerProfile userId);

    List<JobSeekerApply> findByJob(JobPostActivity job);
}
