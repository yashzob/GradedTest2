package com.CustomerRelationshipManagemanet.First.controller;

import java.util.Set;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CustomerRelationshipManagemanet.First.Model.Customer;
import com.CustomerRelationshipManagemanet.First.service.CustomerService;

@RestController
@RequestMapping("/api/customer")
public class CustomerRestController {

	private final CustomerService customerService;

	public CustomerRestController(CustomerService studentService) {
		this.customerService = studentService;
	}

	@GetMapping
	public Set<Customer> fetchAllCustomers() {
		return this.customerService.fetchAllCustomer();
	}

	@GetMapping("/{id}")
	public Customer fetchCustomerById(@PathVariable("id") long customerId) {
		
		return this.customerService.fetchCustomerById(customerId);
	}

	@PostMapping
	public void saveCustomer(@RequestBody Customer customer) {
		System.out.println(customer);
		this.customerService.addCustomer(customer);
	}

	@DeleteMapping("/{id}")
	public void deleteCustomerById(@PathVariable("id") long customerId) {
		this.customerService.deleteCustomerById(customerId);
	}

//	@PutMapping("/{id}")
//	public void updateExistingCustomer(@PathVariable("Id") long customerId, @RequestBody Customer customer) {
//		this.customerService.updateCustomer(customerId, customer);
//	}
}
