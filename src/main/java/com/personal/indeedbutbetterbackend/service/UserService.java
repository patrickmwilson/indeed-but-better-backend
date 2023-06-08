package com.personal.indeedbutbetterbackend.service;

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
            User user = googleAuth.validateUser(idToken);
            if(this.findByEmail(user.getEmail()) == null) {
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
        User oldUserRecord = findByEmail(user.getEmail());
        oldUserRecord.setName(user.getName());
        oldUserRecord.setFirstName(user.getFirstName());
        oldUserRecord.setLastName(user.getLastName());
        oldUserRecord.setUserPicture(user.getUserPicture());
        oldUserRecord.setPhoneNumber(user.getPhoneNumber());
        oldUserRecord.setUserType(user.getUserType());

        System.out.println("In user service update");
        System.out.println(oldUserRecord.toString());

        userDao.save(oldUserRecord);
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
