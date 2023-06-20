package com.personal.indeedbutbetterbackend.service;

import com.personal.indeedbutbetterbackend.entity.Notification;
import com.personal.indeedbutbetterbackend.entity.User;
import com.personal.indeedbutbetterbackend.entity.UserNotification;
import com.personal.indeedbutbetterbackend.repository.NotificationDao;
import com.personal.indeedbutbetterbackend.repository.UserDao;
import com.personal.indeedbutbetterbackend.repository.UserNotificationDao;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
@NoArgsConstructor
public class UserNotificationService {
    private UserNotificationDao userNotificationDao;
    private NotificationDao notificationDao;
    private UserDao userDao;

    public void addNotificationToAllApplicableUsers(Notification notification) {
        notificationDao.save(notification);
        List<User> userList = userDao.findAll();
        for(User user:userList) {
            UserNotification userNotification = new UserNotification();
            userNotification.setUser(user);
            userNotification.setNotification(notification);
            this.save(userNotification);
        }
    }

    public List<UserNotification> findByUser(User user) {
        return userNotificationDao.findByUser(user);
    }

    public void save(UserNotification userNotification) {
        userNotificationDao.save(userNotification);
    }

    public void deleteById(Integer id) {
        userNotificationDao.deleteById(id);
    }

}
