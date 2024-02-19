package com.customer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.entity.Customer;
import com.customer.repo.CustomerRepo;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepo customerRepo;
	
	public List<Customer> findAllCustomer(){
		return customerRepo.findAll();
	}
	
	public Optional<Customer> findCustomerBYId(Integer cid) {
		return customerRepo.findById(cid);
	}
	
	public Customer createCustomer(Customer c) {
		return customerRepo.save(c);
	}
	
	public Customer updateCustomer(Integer cid, Customer c) {
		Customer existingCtmr = customerRepo.findById(cid).orElseThrow(() -> new RuntimeException("Customer Not Found"));
		
		if(c.getCname()!=null) {
			existingCtmr.setCname(c.getCname());
		}
		
		if(c.getCemail()!=null) {
			existingCtmr.setCemail(c.getCemail());
		}	
		
		if(c.getGender()!=null) {
			
		}existingCtmr.setGender(c.getGender());
		
		
		return customerRepo.save(existingCtmr);
	}
	
	public String deleteCustomerById(Integer cid) {
		Customer existingCtmr = customerRepo.findById(cid).orElseThrow(() -> new RuntimeException("Customer Not Found"));
		
		customerRepo.deleteById(cid);
		return "Customer Removed";
	}
}
