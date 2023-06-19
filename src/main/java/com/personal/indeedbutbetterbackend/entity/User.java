package com.personal.indeedbutbetterbackend.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="User")
public class User implements UserDetails {

    @Id
    @Column(name="user_id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    private int userId;

    @Column(name="name")
    private String name;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="email",nullable=false,unique=true)
    private String email;

    @Column(name="phone_number")
    private String phoneNumber;

    @Column(name="user_type")
    private String userType;

    @Column(name="user_picture")
    private String userPicture;

    @Column(name="user_title")
    private String userTitle;

    @Column(name="user_description")
    private String userDescription;

    @Column(name="user_location")
    private String userLocation;

    private String jwt;

    public User(String email, String name, String firstName, String lastName, String userPicture) {
        super();
        this.email = email;
        this.name = name;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userPicture = userPicture;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
