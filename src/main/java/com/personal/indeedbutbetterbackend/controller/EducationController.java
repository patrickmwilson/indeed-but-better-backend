package com.personal.indeedbutbetterbackend.controller;

import com.personal.indeedbutbetterbackend.entity.Education;
import com.personal.indeedbutbetterbackend.entity.User;
import com.personal.indeedbutbetterbackend.service.EducationService;
import com.personal.indeedbutbetterbackend.service.UserService;
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
@RequestMapping(value="/education")
@AllArgsConstructor(onConstructor = @__(@Autowired))
@NoArgsConstructor
public class EducationController {

    private EducationService educationService;
    private UserService userService;

    //TODO: Complete this reordering client side, something to do with the way ngFor detects changes not triggering
    @GetMapping("/find-by-user")
    public ResponseEntity<List<Education>> findByUser(@RequestHeader(HttpHeaders.AUTHORIZATION) String authHeader) {
        User user = userService.findByJwtToken(authHeader);
        List<Education> educationList = educationService.findByUser(user);
        educationList.sort((o1, o2) -> o1.getSortIndex().compareTo(o2.getSortIndex()));
        return new ResponseEntity<>(educationList, HttpStatus.OK);
    }

    @PostMapping("/add-to-user")
    public ResponseEntity<String> addEducation(@RequestHeader(HttpHeaders.AUTHORIZATION) String authHeader, @RequestBody Education education) {
        User user = userService.findByJwtToken(authHeader);
        educationService.saveToUser(education, user);
        return new ResponseEntity<>("Education added", HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEducation(@PathVariable("id") Integer educationId) {
        educationService.deleteById(educationId);
        return new ResponseEntity<>("Education deleted", HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<String> updateEducation(@RequestHeader(HttpHeaders.AUTHORIZATION) String authHeader, @RequestBody Education education) {
        User user = userService.findByJwtToken(authHeader);
        educationService.saveToUser(education, user);
        return new ResponseEntity<>("Education updated", HttpStatus.OK);
    }
}
