package com.personal.indeedbutbetterbackend.service;

import com.personal.indeedbutbetterbackend.entity.Notification;
import com.personal.indeedbutbetterbackend.repository.NotificationDao;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
@NoArgsConstructor
public class NotificationService {

    private NotificationDao notificationDao;

    public Notification save(Notification notification) {
       return notificationDao.save(notification);
    }

    public List<Notification> findByType(List<String> typeList) {
        if(typeList.contains("All")) {
            return notificationDao.findAll();
        }
        List<Notification> notificationList = new ArrayList<>();
        for(String type:typeList) {
            notificationList.addAll(notificationDao.findByNotificationType(type));
        }
        return notificationList;
    }
}
