package com.personal.indeedbutbetterbackend.controller;

import com.personal.indeedbutbetterbackend.entity.Skill;
import com.personal.indeedbutbetterbackend.entity.User;
import com.personal.indeedbutbetterbackend.service.SkillService;
import com.personal.indeedbutbetterbackend.service.UserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value="/skills")
@AllArgsConstructor(onConstructor = @__(@Autowired))
@NoArgsConstructor
public class SkillController {

    @Autowired
    private SkillService skillService;

    /*@Autowired
    private JwtService jwtService;*/

    @Autowired
    private UserService userService;




   /* @GetMapping("/find-by-user")
    public ResponseEntity<List<Skill>> getSkillsByUser(@RequestBody String jwt) {
        String userEmail = jwtService.extractEmail(jwt);
        User user = userService.findByEmail(userEmail);
        List<Skill> skillList = skillService.findByUser(user);
        return new ResponseEntity<>(skillList, HttpStatus.OK);
    }*/
}
