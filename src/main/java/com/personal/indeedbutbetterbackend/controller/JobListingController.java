package com.personal.indeedbutbetterbackend.controller;

import com.personal.indeedbutbetterbackend.entity.JobListing;
import com.personal.indeedbutbetterbackend.service.JobListingService;
import com.personal.indeedbutbetterbackend.validator.JobListingValidator;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins="*")
@RestController
@RequestMapping(value="/job-listings")
@AllArgsConstructor(onConstructor = @__(@Autowired))
@NoArgsConstructor
public class JobListingController {

    private JobListingService jobListingService;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(new JobListingValidator());
    }

    @GetMapping("/all")
    public ResponseEntity<List<JobListing>> getAll() {
        List<JobListing> jobListingList = jobListingService.getAll();
        return new ResponseEntity<>(jobListingList, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<String> insertJobListing(@RequestBody @Valid JobListing jobListing, BindingResult result) {
        if(result.hasErrors()) {
            return new ResponseEntity<>(result.getFieldError().getCode() + " " + result.getFieldError().getDefaultMessage(), HttpStatus.NOT_ACCEPTABLE);
        }

        jobListingService.insert(jobListing);
        return new ResponseEntity<>("Resource created", HttpStatus.CREATED);

    }
}
