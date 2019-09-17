package com.project.src.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.src.entity.Customer;
import com.project.src.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerActionController {

	// Inject DAO into our controller
	@Autowired
	private CustomerService customerService;

	@GetMapping("/list")
	public String customerList(Model model) {

		// Get the list of customers from the database
		List<Customer> customers = customerService.customerList();

		// Add customer list to the model
		model.addAttribute("customerList", customers);

		return "customerList";
	}

	@GetMapping("/showFormAddCustomer")
	public String showCustomerAddForm(Model model) {

		// Object of customer
		Customer customer = new Customer();

		model.addAttribute("customer", customer);

		return "add-customer-form";
	}

	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {

		customerService.saveCustomer(customer);

		return "redirect:/customer/list";
	}

	@GetMapping("/showUpdateForm")
	public String showCustomerUpdateForm(@RequestParam("customerId") int theId, Model model) {

		// Get the customer details from customer ID
		Customer customer = customerService.getCustomer(theId);

		// Add the details in the model
		model.addAttribute("customer", customer);

		return "add-customer-form";
	}

	@GetMapping("/showDeleteForm")
	public String deleteForm(@RequestParam("customerId") Integer theId, Model model) {

		// Delete the customer
		customerService.deleteCustomer(theId);

		// Redirect to customer list page after deleting
		return "redirect:/customer/list";
	}

}
