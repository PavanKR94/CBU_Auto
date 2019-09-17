package com.project.src.service;

import java.util.List;

import com.project.src.entity.Customer;

public interface CustomerService {
	
	public List<Customer> customerList();

	public void saveCustomer(Customer customer);

	public Customer getCustomer(int theId);

	public void deleteCustomer(Integer theId);
	
}
