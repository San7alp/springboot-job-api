package com.example.job_app.company;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {
    public CompanyController(CompanyService cs) {
        this.cs = cs;
    }
    private CompanyService cs;

    @GetMapping
    public ResponseEntity<List<Company>> getAllComp(){
        return new ResponseEntity<>(cs.getAllComp(),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCompany(@PathVariable Long id,@RequestBody Company company){
        cs.updateCompany(company,id);
        return new ResponseEntity<>("Company updated successfully", HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<String> addComp(@RequestBody Company company){
        cs.createComp(company);
        return new ResponseEntity<>("Company Added", HttpStatus.CREATED);
    }
}
