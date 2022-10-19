package com.CustomerRelationshipManagemanet.First.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.CustomerRelationshipManagemanet.First.Model.Customer;
import com.CustomerRelationshipManagemanet.First.repository.CustomerRepository;

@Service
public class CustomerService {
	// this is a variable Data store
	// private Set<Customer> customer = new HashSet<>();

	private final CustomerRepository customerRepository;

	public CustomerService(CustomerRepository customerRepository) {
		this.customerRepository=customerRepository;
	}

	public Customer addCustomer(Customer customer) {
		System.out.println("Saving a Customer....");
		System.out.println(customer);
		Customer savedCustomer=this.customerRepository.save(customer);
		return savedCustomer;
	}

	public Set<Customer> fetchAllCustomer() {
		return new HashSet<>(this.customerRepository.findAll());

	}

	public Customer fetchCustomerById(long customerId) {
		return this.customerRepository
				.findById(customerId)
				.orElseThrow(
				() -> new IllegalArgumentException("Invalid CustomerId Is passed, Please enter the right one"));
	}

	public void deleteCustomerById(long customerId) {
		this.customerRepository.deleteById(customerId);
	}
	
	public Customer updateCustomer(long customerId,Customer updatedCustomer) {
		Customer customerFromRepository= this.fetchCustomerById(customerId);
		customerFromRepository.setEmail(updatedCustomer.getEmail());
		customerFromRepository.setFirstName(updatedCustomer.getFirstName());
		customerFromRepository.setLastName(updatedCustomer.getLastName());
		return customerFromRepository;
		
	}
}
