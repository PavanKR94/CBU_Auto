package com.project.src.dao;

import java.util.List;
import com.project.src.entity.Customer;

public interface CustomerDAO {

	// Show customer list
	public List<Customer> customerList();

	// Save the new/updated customer
	public void saveCustomer(Customer customer);

	// Get the customer details by id
	public Customer getCustomer(int theId);

	// Delete the customer entry
	public void deleteCustomer(Integer theId);	
	
}
