package com.personal.indeedbutbetterbackend.service;

import com.personal.indeedbutbetterbackend.entity.User;
import com.personal.indeedbutbetterbackend.repository.UserDao;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
@NoArgsConstructor
public class UserService {

    @Autowired
    private UserDao userDao;

    public User findByEmail(String email) {
        return this.userDao.findUserByEmail(email);
    }

    public User findById(int id) {
        return this.userDao.findUserByUserId(id);
    }

    public void insert(User user) {
        this.userDao.save(user);
    }

    //TODO:DELETE
    public List<User> getAll() {
        return this.userDao.findAll();
    }


}
