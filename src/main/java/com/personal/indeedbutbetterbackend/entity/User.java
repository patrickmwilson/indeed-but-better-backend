package com.personal.indeedbutbetterbackend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="User")
public class User {

    @Id
    @Column(name="user_id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    private int userId;

    @Column(name="name")
    private String name;

    @Column(name="email",nullable=false,unique=true)
    private String email;

    @Column(name="phone_number")
    private String phoneNumber;

    @Column(name="user_type")
    private String userType;

    public User(String email, String name) {
        super();
        this.email = email;
        this.name = name;
    }

}
