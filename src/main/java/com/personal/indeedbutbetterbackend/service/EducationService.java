package com.personal.indeedbutbetterbackend.service;

import com.personal.indeedbutbetterbackend.entity.Education;
import com.personal.indeedbutbetterbackend.entity.User;
import com.personal.indeedbutbetterbackend.repository.EducationDao;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
@NoArgsConstructor
public class EducationService {

    @Autowired
    private EducationDao educationDao;

    public List<Education> findByUser(User user) {
        return educationDao.findByUser(user);
    }

    public void saveToUser(Education education, User user) {
        education.setUser(user);
        educationDao.save(education);
    }

    public void deleteById(Integer educationId) {
        educationDao.deleteById(educationId);
    }
}
