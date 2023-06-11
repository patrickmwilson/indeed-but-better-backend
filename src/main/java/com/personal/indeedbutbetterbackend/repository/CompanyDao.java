package com.personal.indeedbutbetterbackend.repository;

import com.personal.indeedbutbetterbackend.entity.Company;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CompanyDao extends JpaRepository<Company, Integer> {
    Company findById(int id);
    Page<Company> findCompanyByNameContainsOrIndustryContainsOrAddress_CityContainsOrAddress_StateContainsAllIgnoreCase(String companyName, String industry, String city, String state, PageRequest pageable);

}