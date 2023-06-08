package com.personal.indeedbutbetterbackend.repository;

import com.personal.indeedbutbetterbackend.entity.Skill;
import com.personal.indeedbutbetterbackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SkillDao extends JpaRepository<Skill, Integer> {

    List<Skill> findByUser(User user);

}
