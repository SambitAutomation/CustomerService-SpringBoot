package com.customer.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customer.entity.Customer;
import com.customer.service.CustomerService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("cust")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/allCst")
	public ResponseEntity<List<Customer>> getAllCustomer(){
		return new ResponseEntity<>(customerService.findAllCustomer(), HttpStatus.OK);
	}
	
	@PostMapping("/createCst")
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer c){
		return new ResponseEntity<>(customerService.createCustomer(c), HttpStatus.CREATED);
	}
	
	@PutMapping("/updateCst/{cid}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable Integer cid, @RequestBody Customer c){
		return new ResponseEntity<>(customerService.updateCustomer(cid, c), HttpStatus.OK);
	}
	
	@GetMapping("/cst/{cid}")
	public ResponseEntity<Optional<Customer>> getCustomerById(@PathVariable Integer cid){
		return new ResponseEntity<>(customerService.findCustomerBYId(cid), HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteCst/{cid}")
	public ResponseEntity<String> deleteCustomerById(@PathVariable Integer cid){
		return new ResponseEntity<>(customerService.deleteCustomerById(cid), HttpStatus.OK);
	}
}
