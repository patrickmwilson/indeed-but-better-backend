package com.personal.indeedbutbetterbackend.repository;

import com.personal.indeedbutbetterbackend.entity.Application;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ApplicationDao extends JpaRepository<Application, Integer> {


    Page<Application> findApplicationsByApplicantUserId(int userId, PageRequest pageable);
    Page<Application> findApplicationsByJobListingJobListingId(int jobId, PageRequest pageable);

    Page<Application> findApplicationsByApplicant_FirstNameContainsOrApplicant_LastNameContainsAndJobListing_JobListingIdAllIgnoreCase(String fname, String lname, int jobListingId, PageRequest pageable);

    Page<Application> findApplicationsByJobListing_Company_NameContainsOrJobListing_JobTitleContainsAndApplicant_UserIdAllIgnoreCase(String cName, String title, int userId, PageRequest pageable);
}
