package com.personal.indeedbutbetterbackend.repository;

import com.personal.indeedbutbetterbackend.entity.Application;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ApplicationDao extends JpaRepository<Application, Integer> {


    List<Application> findApplicationsByApplicantUserId(int userId);
    Page<Application> findApplicationsByJobListingJobListingId(int jobId, PageRequest pageable);

    Page<Application> findApplicationsByApplicant_FirstNameContainsOrApplicant_LastNameContainsAndJobListing_JobListingIdAllIgnoreCase(String fname, String lname, int jobListingId, PageRequest pageable);
}
