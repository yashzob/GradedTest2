package com.CustomerRelationshipManagemanet.First.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.CustomerRelationshipManagemanet.First.Model.Customer;
@Service
public class CustomerService {
	// this is a variable Data store
	private Set<Customer> customer = new HashSet<>();

	public void addCustomer(Customer customer) {
		System.out.println("Saving a Customer....");
		System.out.println(customer);
		this.customer.add(customer);
	}

	public Set<Customer> fetchAllCustomer() {
		return this.customer;

	}

	public Customer fetchCustomerById(long customerId) {
		return this.customer
				.stream()
				.filter(customer -> customer.getId() == customerId)
				.findAny()
				.orElseThrow(
				() -> new IllegalArgumentException("Invalid CustomerId Is passed, Please enter the right one"));
	}

	public void deleteCustomerById(long customerId) {
		this.customer.removeIf(customer -> customer.getId() == customerId);
	}

}
