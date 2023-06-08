package com.personal.indeedbutbetterbackend.repository;

import com.personal.indeedbutbetterbackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDao extends JpaRepository<User, Integer> {

    public User findUserByEmail(String email);
    public User findUserByUserId(int id);

    public Optional<User> findByEmail(String email);
}
