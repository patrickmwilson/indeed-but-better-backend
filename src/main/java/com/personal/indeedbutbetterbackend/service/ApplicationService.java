package com.personal.indeedbutbetterbackend.service;

import com.personal.indeedbutbetterbackend.entity.Application;
import com.personal.indeedbutbetterbackend.repository.ApplicationDao;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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

    public List<Application> getApplicationsByJobListingId(int jobListingId) { return  this.applicationDao.findApplicationsByJobListingJobListingId(jobListingId); }

}
