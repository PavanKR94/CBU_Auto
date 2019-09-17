package com.project.src.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.src.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	// Inject the session factory created in dispatcher servlet
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> customerList() {

		// Create a session
		Session session = sessionFactory.getCurrentSession();

		// Generate a query
		Query<Customer> customerListQuery = session.createQuery("from CustomerList order by first_name",
				Customer.class);

		// Get the customer list
		List<Customer> customerList = customerListQuery.getResultList();

		// return the results
		return customerList;

	}

	@Override
	public void saveCustomer(Customer customer) {

		// Create a session
		Session session = sessionFactory.getCurrentSession();

		// Save a new customer
		session.saveOrUpdate(customer);

	}

	@Override
	public Customer getCustomer(int theId) {

		// Create a session
		Session session = sessionFactory.getCurrentSession();

		// Create a new customer object
		Customer customer = session.get(Customer.class, theId);

		// Return the customer details obtained the ID
		return customer;

	}

	@Override
	public void deleteCustomer(Integer theId) {

		// Create a new session for transaction
		Session session = sessionFactory.getCurrentSession();

		// delete the customer with customerID
		session.createQuery("delete from CustomerList where id=" + theId).executeUpdate();

	}

}
