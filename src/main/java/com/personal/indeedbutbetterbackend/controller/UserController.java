package com.personal.indeedbutbetterbackend.controller;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.googleapis.auth.oauth2.GooglePublicKeysManager;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.LowLevelHttpRequest;
import com.personal.indeedbutbetterbackend.entity.User;
import com.personal.indeedbutbetterbackend.service.UserService;
import com.personal.indeedbutbetterbackend.validator.UserValidator;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.net.http.HttpClient;
import java.util.*;

//@CrossOrigin(origins="*")
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value="/users")
@AllArgsConstructor(onConstructor = @__(@Autowired))
@NoArgsConstructor
public class UserController {

    private UserService userService;

    //private String clientId = "583369200281-ubok9tafv7bf6rm259jhklq30clh2fbs.apps.googleusercontent.com";

    @PostMapping("/LoginWithGoogle")
    public ResponseEntity<String> login(@RequestBody String credential) throws IOException {

        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httppost = new HttpPost("https://oauth2.googleapis.com/tokeninfo");

// Request parameters and other properties.
        Map<String, String> params = new HashMap<>();
        params.put("id_token", credential);

//Execute and get the response.
        HttpResponse response = httpclient.execute(httppost);
        HttpEntity entity = response.getEntity();
        System.out.println(response.getStatusLine().getStatusCode());
        System.out.println(response.toString());
        return new ResponseEntity<>(entity.toString(),HttpStatus.OK);
    }

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
