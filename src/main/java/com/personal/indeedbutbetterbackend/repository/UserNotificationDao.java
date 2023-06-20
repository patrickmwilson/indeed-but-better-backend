package com.personal.indeedbutbetterbackend.repository;

import com.personal.indeedbutbetterbackend.entity.User;
import com.personal.indeedbutbetterbackend.entity.UserNotification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserNotificationDao extends JpaRepository<UserNotification, Integer> {
    List<UserNotification> findByUser(User user);
}
