package com.personal.indeedbutbetterbackend.repository;

import com.personal.indeedbutbetterbackend.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificationDao extends JpaRepository<Notification, Integer> {

    List<Notification> findByNotificationType(String notificationType);
}
