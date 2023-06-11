package com.personal.indeedbutbetterbackend.controller;

import com.personal.indeedbutbetterbackend.entity.User;
import com.personal.indeedbutbetterbackend.entity.WorkExperience;
import com.personal.indeedbutbetterbackend.service.UserService;
import com.personal.indeedbutbetterbackend.service.WorkExperienceService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value="/work-experience")
@AllArgsConstructor(onConstructor = @__(@Autowired))
@NoArgsConstructor
public class WorkExperienceController {

    @Autowired
    private WorkExperienceService workExperienceService;

    @Autowired
    private UserService userService;

    @GetMapping("/find-by-user")
    public ResponseEntity<List<WorkExperience>> findByUser(@RequestHeader(HttpHeaders.AUTHORIZATION) String authHeader) {
        User user = userService.findByJwtToken(authHeader);
        List<WorkExperience> workExperienceList = workExperienceService.findByUser(user);
        return new ResponseEntity<>(workExperienceList, HttpStatus.OK);
    }

    @PostMapping("/add-to-user")
    public ResponseEntity<String> addWorkExperience(@RequestHeader(HttpHeaders.AUTHORIZATION) String authHeader, @RequestBody WorkExperience workExperience) {
        User user = userService.findByJwtToken(authHeader);
        workExperienceService.saveToUser(workExperience, user);
        return new ResponseEntity<>("Work experience added", HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteWorkExperience(@PathVariable("id") Integer workExperienceId) {
        workExperienceService.deleteById(workExperienceId);
        return new ResponseEntity<>("Work experience deleted", HttpStatus.OK);
    }
}
