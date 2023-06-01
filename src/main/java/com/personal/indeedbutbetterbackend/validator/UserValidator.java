package com.personal.indeedbutbetterbackend.validator;

import com.personal.indeedbutbetterbackend.entity.JobListing;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class UserValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return JobListing.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "email", "email.empty", "email must have a value");
    }
}
