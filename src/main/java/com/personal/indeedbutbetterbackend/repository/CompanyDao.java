package com.personal.indeedbutbetterbackend.repository;

import com.personal.indeedbutbetterbackend.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CompanyDao extends JpaRepository<Company, Integer> {

}