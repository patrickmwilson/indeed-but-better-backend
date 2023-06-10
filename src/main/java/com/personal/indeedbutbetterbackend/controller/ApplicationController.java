package com.personal.indeedbutbetterbackend.controller;

import com.personal.indeedbutbetterbackend.entity.Application;
import com.personal.indeedbutbetterbackend.entity.JobListing;
import com.personal.indeedbutbetterbackend.service.ApplicationService;
import com.personal.indeedbutbetterbackend.service.JobListingService;
import com.personal.indeedbutbetterbackend.service.UserService;
import com.personal.indeedbutbetterbackend.entity.User;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins="*")
@RestController
@RequestMapping(value="/applications")
@AllArgsConstructor(onConstructor = @__(@Autowired))
@NoArgsConstructor
public class ApplicationController {

    private ApplicationService applicationService;
    private UserService userService;
    private JobListingService jobListingService;


    @GetMapping("/all")
    public ResponseEntity<List<Application>> getAll() {
        List<Application> applications = applicationService.getAll();

        return new ResponseEntity<>(applications, HttpStatus.OK);
    }

    @PostMapping("job-listings/{jobListingId}/create")
    public ResponseEntity<String> insertApplication(@RequestHeader(HttpHeaders.AUTHORIZATION) String authHeader, @PathVariable(value = "jobListingId") int jobListingId, @RequestBody @Valid Application application) {

        User user = userService.findByJwtToken(authHeader);
        JobListing job = this.jobListingService.getJobListingById(jobListingId);
        application.setApplicant(user);
        application.setJobListing(job);

        applicationService.insert(application);
        return new ResponseEntity<>("Resource created", HttpStatus.CREATED);
    }

    @GetMapping("/job-listings/{jobListingId}/page/{page}")
    public ResponseEntity<Page<Application>> getApplicationsByJobListingId(@PathVariable(value = "jobListingId") int jobListingId, @PathVariable(value = "page") int page) {
        Page<Application> applicationPage = applicationService.getApplicationsByJobListingId(jobListingId, page);

        return new ResponseEntity<>(applicationPage, HttpStatus.OK);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Application>> getApplicationsByUserId(@PathVariable(value = "userId") int userId) {
        List<Application> applications = applicationService.getApplicationsByUserId(userId);

        return new ResponseEntity<>(applications, HttpStatus.OK);
    }
    @GetMapping("/job-listings/{jobListingId}/search/{query}/page/{page}")
    public ResponseEntity<Page<Application>> searchByJobListingId(@PathVariable(value = "query") String query, @PathVariable(value = "page") int page, @PathVariable(value = "jobListingId") int jobListingId) {
        Page<Application> applicationPage = applicationService.searchByJobListingId(query, page, jobListingId);
        return new ResponseEntity<>(applicationPage, HttpStatus.OK);
    }

}