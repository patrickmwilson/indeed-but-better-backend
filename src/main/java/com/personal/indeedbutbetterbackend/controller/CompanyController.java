package com.personal.indeedbutbetterbackend.controller;

import com.personal.indeedbutbetterbackend.entity.Company;
import com.personal.indeedbutbetterbackend.service.CompanyService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@CrossOrigin(origins="*")
@RestController
@RequestMapping(value="/companies")
@AllArgsConstructor(onConstructor = @__(@Autowired))
@NoArgsConstructor
public class CompanyController {

    private CompanyService companyService;

    @GetMapping("/all")
    public ResponseEntity<List<Company>> getAll() {
        List<Company> companyList = companyService.getAll();
        companyList.add(new Company(1, "Company 1", "500-100", "Finance", "USA"));
        companyList.add(new Company(2, "Company 2", "500-100","Finance", "USA"));
        companyList.add(new Company(3, "Company 3", "500-100","Finance", "USA"));
        companyList.add(new Company(4, "Company 4", "500-100","Finance", "USA"));
        companyList.add(new Company(5, "Company 5", "500-100","Finance", "USA"));
        companyList.add(new Company(6, "Company 6", "500-100","Finance", "USA"));
        companyList.add(new Company(7, "Company 7", "500-100","Finance", "USA"));
        companyList.add(new Company(8, "Company 8", "500-100","Finance", "USA"));


        return new ResponseEntity<>(companyList, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<String> insertCompany(@RequestBody Company company) {
        companyService.insert(company);
        return new ResponseEntity<>("Resource created", HttpStatus.CREATED);
    }
}