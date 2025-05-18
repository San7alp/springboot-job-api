package com.example.job_app.job;

import com.example.job_app.company.Company;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class JobController {
    public JobController(JobService j) {
        this.j = j;
    }

    private JobService j;

    @GetMapping("/jobs")
    public ResponseEntity<List<Job>> findall(){
        return ResponseEntity.ok(j.findAll());
    }
    @PostMapping("/jobs")
    public ResponseEntity<String> createjob(@RequestBody Job job){
        j.createJob(job);
//        Company c=job.getCompany();
        return new ResponseEntity<>("job added",HttpStatus.CREATED);
    }
    @GetMapping("/jobs/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id){
        Job job=j.getJobById(id);
        if(job!=null){
            return new ResponseEntity<>(job,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/jobs/{id}")
    public ResponseEntity<String> deleteJob(@PathVariable Long id){
        Boolean d=j.deleteJob(id);
        if(d){
            return new ResponseEntity<>("Job successfully deleted",HttpStatus.OK);
        }
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PutMapping("/jobs/{id}")
    public ResponseEntity<String> putJob(@PathVariable Long id,@RequestBody Job updatedjob){
        Boolean upd=j.putJob(id,updatedjob);
        if(upd){
            return new ResponseEntity<>("Job updated",HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}
/*
GET /jobs: Get all jobs
GET /jobs/{id}: Get a specific job by ID
POST /jobs: Create a new job (request body should contain the job details)
DELETE /jobs/{id}: Delete a specific job by ID
PUT /jobs/{id}: Update a specific job by ID (request body should contain the updated jobs

Example API URLs:
GET {base_url}/jobs
GET {base_url}/jobs/1
POST {base_url}/jobs
DELETE {base_url}/jobs/1
PUT {base_url}/jobs/1

 */
