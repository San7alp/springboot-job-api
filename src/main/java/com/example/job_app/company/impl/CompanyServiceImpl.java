package com.example.job_app.company.impl;

import com.example.job_app.company.Company;
import com.example.job_app.company.CompanyRepo;
import com.example.job_app.company.CompanyService;
import com.example.job_app.job.Job;
import jakarta.persistence.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {
    public CompanyServiceImpl(CompanyRepo cr) {
        this.cr = cr;
    }
    private CompanyRepo cr;


    @Override
    public List<Company> getAllComp() {
        return cr.findAll();
    }

    @Override
    public boolean updateCompany(Company company, Long id) {
        Optional<Company> copt = cr.findById(id);
        if (copt.isPresent()) {
            Company companyToUpdate = copt.get();
            companyToUpdate.setName(company.getName());
            companyToUpdate.setDesc(company.getDesc());
            // Do NOT update the ID
            cr.save(companyToUpdate);
            return true;
        }
        return false;
    }


    @Override
    public void createComp(Company company) {
        cr.save(company);
    }
}
