package com.personal.indeedbutbetterbackend.controller;

import com.personal.indeedbutbetterbackend.entity.User;
import com.personal.indeedbutbetterbackend.service.JwtService;
import com.personal.indeedbutbetterbackend.service.UserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

//@CrossOrigin(origins="*")
@CrossOrigin
@RestController
@RequestMapping(value="/users")
@AllArgsConstructor(onConstructor = @__(@Autowired))
@NoArgsConstructor
public class UserController {

    private UserService userService;

    private JwtService jwtService;

    @PostMapping("/login-with-google")
    public ResponseEntity<User> login(@RequestBody String credential)  {
        User user = userService.validateUserSignInWithGoogle(credential);
        if(user == null) {
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
        user.setJwt(jwtService.generateToken(user.getEmail()));
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody User user) {
        return new ResponseEntity<>(null,HttpStatus.OK);
    }

    //NOT IN USER, ALL AUTH HANDLED THROUGH GOOGLE
    @PostMapping("/create")
    public ResponseEntity<String> insertUser(@RequestBody @Valid User user, BindingResult result) {
        System.out.println("In create user");
        if(result.hasErrors()) {
            return new ResponseEntity<>(result.getFieldError().getCode() + " " + result.getFieldError().getDefaultMessage(), HttpStatus.NOT_ACCEPTABLE);
        }else if(this.userService.findByEmail(user.getEmail()) != null) {
            return new ResponseEntity<>("User already exists", HttpStatus.ALREADY_REPORTED);
        }
        this.userService.insert(user);
        return new ResponseEntity<>("Resource created", HttpStatus.CREATED);
    }

    @CrossOrigin
    @PostMapping("/update")
    public ResponseEntity<String> updateUser(@RequestBody User user) {
        System.out.println("In update user");
        System.out.println(user.toString());
        /*if(result.hasErrors()) {
            return new ResponseEntity<>(result.getFieldError().getCode() + " " + result.getFieldError().getDefaultMessage(), HttpStatus.NOT_ACCEPTABLE);
        }*/
        userService.update(user);
        return new ResponseEntity<>("Successfully updated", HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAll() {
        System.out.println("In get All users");
        List<User> userList = this.userService.getAll();
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

    @GetMapping("/{email}")
    public ResponseEntity<User> getUserByEmail(@PathVariable("email") String email) {
        System.out.println("In get user by email");
        User user = userService.findByEmail(email);
        if(user == null) {
            return new ResponseEntity<>(user, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
