package com.personal.indeedbutbetterbackend.service;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.personal.indeedbutbetterbackend.auth.GoogleAuth;
import com.personal.indeedbutbetterbackend.entity.User;
import com.personal.indeedbutbetterbackend.repository.UserDao;
import com.personal.indeedbutbetterbackend.util.JwtTokenUtil;
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

    @Autowired
    private JwtTokenUtil jwtUtil;

    public User validateUserSignInWithGoogle(String idToken) {
        try {
            GoogleAuth googleAuth = new GoogleAuth();
            GoogleIdToken.Payload payload = googleAuth.validateUser(idToken);
            User user = this.findByEmail(payload.getEmail());
            if(user == null) {
                user = new User(payload.getEmail(), (String) payload.get("name"), (String) payload.get("given_name"), (String) payload.get("family_name"), (String) payload.get("picture"));
                this.insert(user);
            }
            return user;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public User findByJwtToken(String authHeader) {
        String token = authHeader.substring(7);
        String email = jwtUtil.getSubject(token);
        return this.findByEmail(email);
    }

    public void update(User user) {
        userDao.save(user);
    }

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
