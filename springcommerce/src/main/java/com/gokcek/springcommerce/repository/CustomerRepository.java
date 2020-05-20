package com.gokcek.springcommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gokcek.springcommerce.model.Customer;


public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
