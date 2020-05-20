package com.gokcek.springcommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gokcek.springcommerce.model.Customer;
import com.gokcek.springcommerce.repository.CustomerRepository;;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository CustomerRepository;

    public List<Customer> findAll() {

        return CustomerRepository.findAll();
    }
    
    public Optional<Customer> findById(Long CustomerId) {
    	
    	
    	return CustomerRepository.findById(CustomerId);
    }

    public Long count() {

        return CustomerRepository.count();
    }

    public void deleteById(Long CustomerId) {

        CustomerRepository.deleteById(CustomerId);
    }
    
    public void saveCustomer(Customer Customer) {
    	
    	 CustomerRepository.save(Customer);
    }
    
    public void updateCustomer(Customer Customer) {
    	    	
    	
    	Customer st = CustomerRepository.findById(Customer.getId()).orElse(null);
    	
    	st.setFname(Customer.getFname());
    	st.setLname(Customer.getLname());
    	st.setCity(Customer.getCity());
    	st.setEmail(Customer.getEmail());

    	
    	CustomerRepository.save(st);
    	
    }
    
    
}
