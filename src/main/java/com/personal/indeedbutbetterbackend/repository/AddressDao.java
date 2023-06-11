package com.personal.indeedbutbetterbackend.repository;

import com.personal.indeedbutbetterbackend.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AddressDao extends JpaRepository<Address, Integer> {

}