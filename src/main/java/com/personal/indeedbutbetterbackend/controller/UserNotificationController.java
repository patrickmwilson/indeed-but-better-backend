package com.personal.indeedbutbetterbackend.controller;

import com.personal.indeedbutbetterbackend.entity.Notification;
import com.personal.indeedbutbetterbackend.entity.User;
import com.personal.indeedbutbetterbackend.entity.UserNotification;
import com.personal.indeedbutbetterbackend.service.UserNotificationService;
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
@RequestMapping(value="/user-notifications")
@AllArgsConstructor(onConstructor = @__(@Autowired))
@NoArgsConstructor
public class UserNotificationController {
    private UserNotificationService userNotificationService;
    private UserService userService;
    @GetMapping("/by-user")
    public ResponseEntity<List<UserNotification>> getNotificationsForUser(@RequestHeader(HttpHeaders.AUTHORIZATION) String authHeader) {
        User user = userService.findByJwtToken(authHeader);
        List<UserNotification> userNotifications = userNotificationService.findByUser(user);
        return new ResponseEntity<>(userNotifications, HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<String> updateUserNotification(@RequestHeader(HttpHeaders.AUTHORIZATION) String authHeader, @RequestBody UserNotification userNotification) {
        User user = userService.findByJwtToken(authHeader);
        userNotification.setUser(user);
        userNotificationService.save(userNotification);
        return new ResponseEntity<>("User notification updated successfully", HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUserNotification(@RequestHeader(HttpHeaders.AUTHORIZATION) String authHeader, @PathVariable("id") Integer userNotificationId) {
        userNotificationService.deleteById(userNotificationId);
        return new ResponseEntity<>("Successfully deleted user notification", HttpStatus.OK);
    }
}
