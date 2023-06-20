package com.personal.indeedbutbetterbackend.service;

import com.personal.indeedbutbetterbackend.entity.User;
import com.personal.indeedbutbetterbackend.entity.WorkExperience;
import com.personal.indeedbutbetterbackend.repository.WorkExperienceDao;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
@NoArgsConstructor
public class WorkExperienceService {

    private WorkExperienceDao workExperienceDao;

    public List<WorkExperience> findByUser(User user) {
        return workExperienceDao.findByUser(user);
    }

    public void saveToUser(WorkExperience workExperience, User user) {
        workExperience.setUser(user);
        workExperienceDao.save(workExperience);
    }

    public void deleteById(Integer workExperienceId) {
        workExperienceDao.deleteById(workExperienceId);
    }
}
