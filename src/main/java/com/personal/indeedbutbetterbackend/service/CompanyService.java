package com.personal.indeedbutbetterbackend.service;

import com.personal.indeedbutbetterbackend.entity.Address;
import com.personal.indeedbutbetterbackend.entity.Company;
import com.personal.indeedbutbetterbackend.repository.AddressDao;
import com.personal.indeedbutbetterbackend.repository.CompanyDao;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
