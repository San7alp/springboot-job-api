package com.example.job_app.job.impl;
import java.util.ArrayList;
import com.example.job_app.job.Job;
import com.example.job_app.job.JobRepo;
import com.example.job_app.job.JobService;
import org.springframework.stereotype.Service;
import java.util.Iterator;


import java.util.List;
import java.util.Optional;

@Service
public class JobServiceimpl implements JobService {
    public JobServiceimpl(JobRepo jp) {
        this.jp = jp;
    }

    //private List <Job> jobs=new ArrayList<>();
    JobRepo jp;

    @Override
    public List<Job> findAll() {
        return jp.findAll();
    }

    @Override
    public void createJob(Job job) {
//        job.setId(id++);
    jp.save(job);
    }

    @Override
    public Job getJobById(Long id) {
        return jp.findById(id).orElse(null);
    }
    public Boolean deleteJob(Long id){
        try{
            jp.deleteById(id);
                return true;
            } catch (Exception e) {
            return false;
        }
        }
    @Override
    public Boolean putJob(Long id, Job updatedjob) {
        Optional<Job> jopt=jp.findById(id);
            if(jopt.isPresent()){
                Job job=jopt.get();
                job.setTitle(updatedjob.getTitle());
                job.setDesc(updatedjob.getDesc());
                job.setMinSal(updatedjob.getMinSal());
                job.setMaxSal(updatedjob.getMaxSal());
                job.setLoc(updatedjob.getLoc());
                jp.save(job);
                return true;
            }
        return false;
        }

    }

