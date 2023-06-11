package com.personal.indeedbutbetterbackend.service;

import com.personal.indeedbutbetterbackend.entity.JobListing;
import com.personal.indeedbutbetterbackend.repository.JobListingDao;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
@NoArgsConstructor
public class JobListingService {

    @Autowired
    public JobListingDao jobListingDao;

    public List<JobListing> getAll(){
        return this.jobListingDao.findAll();
    }

    public JobListing getJobListingById(int id) {return this.jobListingDao.findJobListingByJobListingId(id);}

    public void insert(JobListing jobListing) {
        jobListingDao.save(jobListing);
    }

    public Page<JobListing> getJobListingsByCompanyId(int companyId, int page) { return this.jobListingDao.findJobListingsByCompanyId(companyId, PageRequest.of(page, 5)); }
    public Page<JobListing> getJobListingsByUser(int userId, int page) { return this.jobListingDao.findJobListingsByUserUserId(userId, PageRequest.of(page, 5)); }

    public Page<JobListing> getAll(int page){
        return this.jobListingDao.findAll(PageRequest.of(page, 5));
    }
    public Page<JobListing> search(String query, int page){

        return jobListingDao.findJobListingsByJobTitleContainsOrDescriptionContainsOrCompany_NameContainsOrCompany_Address_CityContainsOrCompany_Address_StateContainsAllIgnoreCase(query, query, query, query, query, PageRequest.of(page, 5));
    }
    public Page<JobListing> searchbyUser(String query, int page, int userId){

        return jobListingDao.findJobListingsByJobTitleContainsOrDescriptionContainsOrCompany_NameContainsOrCompany_Address_CityContainsOrCompany_Address_StateContainsAndUserUserIdAllIgnoreCase(query, query, query, query, query, userId, PageRequest.of(page, 5));
    }



}
