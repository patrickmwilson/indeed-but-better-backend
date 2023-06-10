package com.personal.indeedbutbetterbackend.controller;

import com.personal.indeedbutbetterbackend.entity.JobListing;
import com.personal.indeedbutbetterbackend.service.JobListingService;
import com.personal.indeedbutbetterbackend.service.UserService;
import com.personal.indeedbutbetterbackend.validator.JobListingValidator;
import com.personal.indeedbutbetterbackend.entity.User;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
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
    private UserService userService;

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
    public ResponseEntity<String> insertJobListing(@RequestHeader(HttpHeaders.AUTHORIZATION) String authHeader, @RequestBody @Valid JobListing jobListing, BindingResult result) {
        if(result.hasErrors()) {
            return new ResponseEntity<>(result.getFieldError().getCode() + " " + result.getFieldError().getDefaultMessage(), HttpStatus.NOT_ACCEPTABLE);
        }

        User user = userService.findByJwtToken(authHeader);
        jobListing.setUser(user);
        jobListingService.insert(jobListing);
        return new ResponseEntity<>("Resource created", HttpStatus.CREATED);
    }

    @GetMapping("/companies/{companyId}/page/{page}")
    public ResponseEntity<Page<JobListing>> getJobListingsByCompanyId(@PathVariable(value = "companyId") int companyId, @PathVariable(value = "page") int page) {
        Page<JobListing> jobListingPage = jobListingService.getJobListingsByCompanyId(companyId, page);
        return new ResponseEntity<>(jobListingPage, HttpStatus.OK);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<List<JobListing>> getJobListingsByUserId(@PathVariable(value = "userId") int userId) {
        List<JobListing> jobListingList = jobListingService.getJobListingsByUserId(userId);
        return new ResponseEntity<>(jobListingList, HttpStatus.OK);
    }
    @GetMapping("/page/{page}")
    public ResponseEntity<Page<JobListing>> getPage(@PathVariable(value = "page") int page) {
        Page<JobListing> jobPage = jobListingService.getAll(page);
        return new ResponseEntity<>(jobPage, HttpStatus.OK);
    }

    @GetMapping("/search/{query}/page/{page}")
    public ResponseEntity<Page<JobListing>> search(@PathVariable(value = "query") String query, @PathVariable(value = "page") int page) {
        Page<JobListing> jobPage = jobListingService.search(query, page);
        return new ResponseEntity<>(jobPage, HttpStatus.OK);
    }

}
