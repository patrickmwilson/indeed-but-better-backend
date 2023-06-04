package com.personal.indeedbutbetterbackend.controller;

import com.personal.indeedbutbetterbackend.entity.JobListing;
import com.personal.indeedbutbetterbackend.service.JobListingService;
import com.personal.indeedbutbetterbackend.service.UserService;
import com.personal.indeedbutbetterbackend.validator.JobListingValidator;
import com.personal.indeedbutbetterbackend.entity.User;
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
    private UserService userService;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(new JobListingValidator());
    }

    @GetMapping("/all")
    public ResponseEntity<List<JobListing>> getAll() {
        List<JobListing> jobListingList = jobListingService.getAll();
        User user = new User();
        jobListingList.add(new JobListing(1, "Test 1", "Lorem ipsum, dolor sit amet consectetur adipisicing elit. Maiores impedit perferendis suscipit eaque, iste dolor cupiditate blanditiis ratione", 50000, "USA", user));
        jobListingList.add(new JobListing(2, "Test 2", "Lorem ipsum, dolor sit amet consectetur adipisicing elit. Maiores impedit perferendis suscipit eaque, iste dolor cupiditate blanditiis ratione", 500000, "USA", user));
        jobListingList.add(new JobListing(3, "Test 3", "Lorem ipsum, dolor sit amet consectetur adipisicing elit. Maiores impedit perferendis suscipit eaque, iste dolor cupiditate blanditiis ratione", 500000, "USA", user));
        jobListingList.add(new JobListing(4, "Test 4", "Lorem ipsum, dolor sit amet consectetur adipisicing elit. Maiores impedit perferendis suscipit eaque, iste dolor cupiditate blanditiis ratione", 500000, "USA", user));
        jobListingList.add(new JobListing(5, "Test 5", "Lorem ipsum, dolor sit amet consectetur adipisicing elit. Maiores impedit perferendis suscipit eaque, iste dolor cupiditate blanditiis ratione", 500000, "USA", user));
        jobListingList.add(new JobListing(6, "Test 6", "Lorem ipsum, dolor sit amet consectetur adipisicing elit. Maiores impedit perferendis suscipit eaque, iste dolor cupiditate blanditiis ratione", 500000, "USA", user));
        jobListingList.add(new JobListing(7, "Test 7", "Lorem ipsum, dolor sit amet consectetur adipisicing elit. Maiores impedit perferendis suscipit eaque, iste dolor cupiditate blanditiis ratione", 500000, "USA", user));
        jobListingList.add(new JobListing(8, "Test 8", "Lorem ipsum, dolor sit amet consectetur adipisicing elit. Maiores impedit perferendis suscipit eaque, iste dolor cupiditate blanditiis ratione", 500000, "USA", user));

        return new ResponseEntity<>(jobListingList, HttpStatus.OK);
    }

    @PostMapping("/users/{userId}/create")
    public ResponseEntity<String> insertJobListing(@PathVariable(value = "userId") int userId, @RequestBody @Valid JobListing jobListing, BindingResult result) {
        if(result.hasErrors()) {
            return new ResponseEntity<>(result.getFieldError().getCode() + " " + result.getFieldError().getDefaultMessage(), HttpStatus.NOT_ACCEPTABLE);
        }

        User user = this.userService.findById(userId);
        jobListing.setUser(user);
        jobListingService.insert(jobListing);
        return new ResponseEntity<>("Resource created", HttpStatus.CREATED);
    }
}
