package com.personal.indeedbutbetterbackend.service;

import com.personal.indeedbutbetterbackend.entity.Skill;
import com.personal.indeedbutbetterbackend.entity.User;
import com.personal.indeedbutbetterbackend.repository.SkillDao;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
@NoArgsConstructor
public class SkillService {

    @Autowired
    private SkillDao skillDao;

    public List<Skill> findByUser(User user) {
        return skillDao.findByUser(user);
    }

    public void saveToUser(Skill skill, User user) {
        skill.setUser(user);
        skillDao.save(skill);
    }
}
