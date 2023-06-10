package com.personal.indeedbutbetterbackend.repository;

import com.personal.indeedbutbetterbackend.entity.JobListing;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface JobListingDao extends JpaRepository<JobListing, Integer> {
    Page<JobListing> findJobListingsByCompanyId(int companyId, PageRequest pageable);
    JobListing findJobListingByJobListingId(int id);
    List<JobListing> findJobListingsByUserUserId(int userId);
}
