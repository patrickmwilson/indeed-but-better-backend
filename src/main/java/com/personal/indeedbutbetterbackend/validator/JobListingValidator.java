package com.personal.indeedbutbetterbackend.validator;

import com.personal.indeedbutbetterbackend.entity.JobListing;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class JobListingValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return JobListing.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "jobTitle", "jobTitle.empty", "jobTitle must have a value");
        ValidationUtils.rejectIfEmpty(errors, "description", "description.empty", "description must have a value");
        ValidationUtils.rejectIfEmpty(errors, "salary", "salary.empty", "salary must have a value");
        ValidationUtils.rejectIfEmpty(errors, "location", "location.empty", "location must have a value");
    }
}
