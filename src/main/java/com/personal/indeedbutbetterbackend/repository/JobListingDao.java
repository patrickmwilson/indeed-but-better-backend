package com.personal.indeedbutbetterbackend.repository;

import com.personal.indeedbutbetterbackend.entity.JobListing;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobListingDao extends JpaRepository<JobListing, Integer> {
    JobListing findByJobListingId(int id);
    List<JobListing> findAll();
}
