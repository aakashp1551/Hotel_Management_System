package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Repository.CustomerRepository;
import com.example.demo.entity.Customer;

@RestController
	@RequestMapping("/customers")
	public class CustomerController {
	    @Autowired
	    private CustomerRepository customerRepository;

	    @GetMapping
	    public List<Customer> getAllCustomers() {
	        return customerRepository.findAll();
	    }

	    @PostMapping
	    public Customer createCustomer(@RequestBody Customer customer) {
	        return customerRepository.save(customer);
	    }

	    @GetMapping("/{id}")
	    public Customer getCustomerById(@PathVariable Long id) {
	        return customerRepository.findById(id).orElseThrow();
	    }

	    @PutMapping("/{id}")
	    public Customer updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {
	        customer.setId(id);
	        return customerRepository.save(customer);
	    }

	    @DeleteMapping("/{id}")
	    public void deleteCustomer(@PathVariable Long id) {
	        customerRepository.deleteById(id);
	    }

}
