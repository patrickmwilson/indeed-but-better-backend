package com.personal.indeedbutbetterbackend.controller;

import com.personal.indeedbutbetterbackend.entity.Notification;
import com.personal.indeedbutbetterbackend.entity.User;
import com.personal.indeedbutbetterbackend.entity.UserNotification;
import com.personal.indeedbutbetterbackend.service.NotificationService;
import com.personal.indeedbutbetterbackend.service.UserNotificationService;
import com.personal.indeedbutbetterbackend.service.UserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value="/notifications")
@AllArgsConstructor(onConstructor = @__(@Autowired))
@NoArgsConstructor
public class NotificationController {

    private NotificationService notificationService;
    private UserNotificationService userNotificationService;
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<String> createNotification(@RequestBody Notification notification) {
        Notification n = notificationService.save(notification);
        userNotificationService.addNotificationToAllApplicableUsers(n);
        return new ResponseEntity<>("Notification created", HttpStatus.CREATED);
    }

    @GetMapping("/by-user")
    public ResponseEntity<List<Notification>> getNotificationsForUser(@RequestHeader(HttpHeaders.AUTHORIZATION) String authHeader) {
        User user = userService.findByJwtToken(authHeader);
        List<Notification> notifications = new ArrayList<>();

        List<UserNotification> userNotifications = userNotificationService.findByUser(user);
        for(UserNotification userNotification:userNotifications) {
            notifications.add(userNotification.getNotification());
        }

        return new ResponseEntity<>(notifications, HttpStatus.OK);
    }
}
