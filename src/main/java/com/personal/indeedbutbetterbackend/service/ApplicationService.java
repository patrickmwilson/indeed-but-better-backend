package com.personal.indeedbutbetterbackend.service;

import com.personal.indeedbutbetterbackend.entity.Application;
import com.personal.indeedbutbetterbackend.repository.ApplicationDao;
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
public class ApplicationService {

    @Autowired
    public ApplicationDao applicationDao;

    public List<Application> getAll(){
        return this.applicationDao.findAll();
    }

    public void insert(Application application) {
        applicationDao.save(application);
    }

    public List<Application> getApplicationsByUserId(int userId) { return this.applicationDao.findApplicationsByApplicantUserId(userId); }

    public Page<Application> getApplicationsByJobListingId(int jobListingId, int page) { return  this.applicationDao.findApplicationsByJobListingJobListingId(jobListingId, PageRequest.of(page, 5)); }

    public Page<Application> searchByJobListingId(String query, int page, int jobListingId) {return this.applicationDao.findApplicationsByApplicant_FirstNameContainsOrApplicant_LastNameContainsAndJobListing_JobListingIdAllIgnoreCase(query, query, jobListingId, PageRequest.of(page, 5));}
}
