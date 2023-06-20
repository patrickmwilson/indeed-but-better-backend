package com.personal.indeedbutbetterbackend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="User_Notifications")
public class UserNotification {

    @Id
    @Column(name="user_notification_id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    private int userNotificationId;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="user_id")
    @JsonIgnore
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="notification_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Notification notification;

    @Column(name="notification_read")
    private boolean notificationRead;
}
