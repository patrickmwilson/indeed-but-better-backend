package com.personal.indeedbutbetterbackend.repository;

import com.personal.indeedbutbetterbackend.entity.JobListing;
import org.springframework.data.jpa.repository.JpaRepository;


public interface JobListingDao extends JpaRepository<JobListing, Integer> {

}
