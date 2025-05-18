package com.example.job_app.company;

import java.util.List;

public interface CompanyService {
    public List<Company> getAllComp();
    boolean updateCompany(Company Company,Long id);
    void createComp(Company company);

}
