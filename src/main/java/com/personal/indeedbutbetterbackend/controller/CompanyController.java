package com.personal.indeedbutbetterbackend.controller;

import com.personal.indeedbutbetterbackend.entity.Company;
import com.personal.indeedbutbetterbackend.service.CompanyService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

    @GetMapping("/search/{query}/page/{page}")
    public ResponseEntity<Page<Company>> search(@PathVariable(value = "query") String query, @PathVariable(value = "page") int page) {
        Page<Company> companyPage = companyService.search(query, page);
        return new ResponseEntity<>(companyPage, HttpStatus.OK);
    }

    @GetMapping("/page/{page}")
    public ResponseEntity<Page<Company>> getPage(@PathVariable(value = "page") int page) {
        Page<Company> companyPage = companyService.getAll(page);
        return new ResponseEntity<>(companyPage, HttpStatus.OK);
    }

}