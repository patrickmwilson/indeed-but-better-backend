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
        return new ResponseEntity<>(companyList, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<String> insertCompany(@RequestBody Company company) {
        companyService.insert(company);
        return new ResponseEntity<>("Resource created", HttpStatus.CREATED);
    }
}