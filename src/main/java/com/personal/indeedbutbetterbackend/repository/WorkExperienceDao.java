package com.personal.indeedbutbetterbackend.repository;

import com.personal.indeedbutbetterbackend.entity.User;
import com.personal.indeedbutbetterbackend.entity.WorkExperience;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkExperienceDao extends JpaRepository<WorkExperience, Integer> {
    List<WorkExperience> findByUser(User user);
}
