package com.personal.indeedbutbetterbackend.repository;

import com.personal.indeedbutbetterbackend.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ApplicationDao extends JpaRepository<Application, Integer> {


    List<Application> findApplicationsByApplicantUserId(int userId);
    List<Application> findApplicationsByJobListingJobListingId(int jobId);

}
