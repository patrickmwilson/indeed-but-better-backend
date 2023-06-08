package com.personal.indeedbutbetterbackend.repository;

import com.personal.indeedbutbetterbackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDao extends JpaRepository<User, Integer> {

    User findUserByEmail(String email);
    User findUserByUserId(int id);

    Optional<User> findByEmail(String email);
}
