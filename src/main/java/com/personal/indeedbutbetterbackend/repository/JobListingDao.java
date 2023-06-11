package com.personal.indeedbutbetterbackend.repository;

import com.personal.indeedbutbetterbackend.entity.JobListing;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;



public interface JobListingDao extends JpaRepository<JobListing, Integer> {
    Page<JobListing> findJobListingsByCompanyId(int companyId, PageRequest pageable);
    JobListing findJobListingByJobListingId(int id);
    Page<JobListing> findJobListingsByUserUserId(int userId, PageRequest pageable);

    Page<JobListing> findJobListingsByJobTitleContainsOrDescriptionContainsOrCompany_NameContainsOrCompany_Address_CityContainsOrCompany_Address_StateContainsAllIgnoreCase(String title, String description, String companyName, String city, String state, PageRequest pageable);

    Page<JobListing> findJobListingsByJobTitleContainsOrDescriptionContainsOrCompany_NameContainsOrCompany_Address_CityContainsOrCompany_Address_StateContainsAndUserUserIdAllIgnoreCase(String title, String description, String companyName, String city, String state, int userId, PageRequest pageable);

}
