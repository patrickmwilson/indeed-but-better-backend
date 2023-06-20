package com.personal.indeedbutbetterbackend.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="Notification")
public class Notification {

    @Id
    @Column(name="notification_id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    private int notificationId;

    @CreatedDate
    @Column(name="notification_date")
    private Date notificationDate = new Date();

    @Column(name="notification_text",nullable = false)
    private String notificationText;

    @Column(name="notification_type",nullable = false)
    private String notificationType;

    @Column(name="notification_urgency",nullable=false)
    private String notificationUrgency;

}
