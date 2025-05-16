package com.example.job_app.job;

import java.util.List;

public interface JobService {
    List<Job> findAll();
    void createJob(Job job);
    Job getJobById(Long id);
    Boolean deleteJob(Long id);
    Boolean putJob(Long id,Job updatedjob);
}
