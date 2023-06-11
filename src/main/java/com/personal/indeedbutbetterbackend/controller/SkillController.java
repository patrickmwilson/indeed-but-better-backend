package com.personal.indeedbutbetterbackend.controller;

import com.personal.indeedbutbetterbackend.entity.Skill;
import com.personal.indeedbutbetterbackend.entity.User;
import com.personal.indeedbutbetterbackend.service.SkillService;
import com.personal.indeedbutbetterbackend.service.UserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value="/skills")
@AllArgsConstructor(onConstructor = @__(@Autowired))
@NoArgsConstructor
public class SkillController {

    @Autowired
    private SkillService skillService;

    @Autowired
    private UserService userService;

    @GetMapping("/find-by-user")
    public ResponseEntity<List<Skill>> findByUser(@RequestHeader(HttpHeaders.AUTHORIZATION) String authHeader) {
       User user = userService.findByJwtToken(authHeader);
       List<Skill> skillList = skillService.findByUser(user);
       return new ResponseEntity<>(skillList, HttpStatus.OK);
    }

    @PostMapping("/add-to-user")
    public ResponseEntity<String> addSkill(@RequestHeader(HttpHeaders.AUTHORIZATION) String authHeader, @RequestBody Skill skill) {
        User user = userService.findByJwtToken(authHeader);
        skillService.saveToUser(skill, user);
        return new ResponseEntity<>("Skill added", HttpStatus.OK);
    }

    @PostMapping("/update-by-user")
    public ResponseEntity<String> updateSkills(@RequestHeader(HttpHeaders.AUTHORIZATION) String authHeader, @RequestBody List<Skill> skills) {
        User user = userService.findByJwtToken(authHeader);
        for(Skill skill:skills) {
            System.out.println(skill);
        }
        skillService.updateByUser(skills, user);
        return new ResponseEntity<>("Skills updated", HttpStatus.OK);
    }
}
