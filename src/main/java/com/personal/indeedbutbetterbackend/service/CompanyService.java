package com.personal.indeedbutbetterbackend.service;

import com.personal.indeedbutbetterbackend.entity.Address;
import com.personal.indeedbutbetterbackend.entity.Company;
import com.personal.indeedbutbetterbackend.repository.AddressDao;
import com.personal.indeedbutbetterbackend.repository.CompanyDao;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
@NoArgsConstructor
public class CompanyService {

    @Autowired
    public CompanyDao companyDao;

    @Autowired
    public AddressDao addressDao;

    public List<Company> getAll(){
        return this.companyDao.findAll();
    }

    public void insert(Company company) {

        Address savedEntity = addressDao.save(company.getAddress());
        company.setAddress(savedEntity);
        companyDao.save(company);
    }

    public Company findByCompanyId(int id) {
        return this.companyDao.findById(id);
    }

    public List<Company> search(String query){
       var results = new ArrayList<Company>();

        results.addAll(companyDao.findCompanyByNameContainsIgnoreCase(query));
        results.addAll(companyDao.findCompanyByIndustryContainsIgnoreCase(query));
        results.addAll(companyDao.findCompanyByAddress_CityContainsIgnoreCase(query));
        results.addAll(companyDao.findCompanyByAddress_StateContainsIgnoreCase(query));

        return results;
    }

    public Page<Company> getAll(int page) {return this.companyDao.findAll(PageRequest.of(page, 10));}

}
