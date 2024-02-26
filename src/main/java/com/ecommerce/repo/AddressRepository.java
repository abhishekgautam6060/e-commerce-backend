package com.ecommerce.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.controller.model.Address;



public interface AddressRepository extends JpaRepository<Address, Long>{

}
