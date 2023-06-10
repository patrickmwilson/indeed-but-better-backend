package com.personal.indeedbutbetterbackend.repository;

import com.personal.indeedbutbetterbackend.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CompanyDao extends JpaRepository<Company, Integer> {
    Company findById(int id);

    List<Company> findCompanyByNameContainsIgnoreCase(String companyName);
    List<Company> findCompanyByIndustryContainsIgnoreCase(String industry);
    List<Company> findCompanyByAddress_CityContainsIgnoreCase(String city);
    List<Company> findCompanyByAddress_StateContainsIgnoreCase(String state);

}