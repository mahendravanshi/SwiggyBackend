package com.masaischool.serviceimpl;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.masaischool.exception.CustomerNotFoundException;
import com.masaischool.model.Customer;
import com.masaischool.repository.CustomerRepository;
import com.masaischool.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Customer addCustomer(Customer c) {

		customerRepository.save(c);

		return c;
	}

	
}













































































/*
 
 @Override
	public List<Customer> getAllCustomers() {

		List<Customer> customers = customerRepository.findAll();
		if (customers.size() == 0) {
			throw new CustomerNotFoundException("Customers list is not found. Please add customers");
		}

		return customers;
	}

	@Override
	public Customer getCustomerById(Integer id) {

		return customerRepository.findById(id)
				.orElseThrow(() -> new CustomerNotFoundException("No customer with customer id " + id));

	}

	@Override
	public List<Customer> getSortedCustomers(String fieldOne, String dirOne, String fieldTwo, String dirTwo) {
		
		Sort sortOne = dirOne.equalsIgnoreCase("ASC")?Sort.by(Sort.Direction.ASC,fieldOne):Sort.by(Sort.Direction.DESC,fieldOne);
		Sort sortTwo = dirTwo.equalsIgnoreCase("ASC")?Sort.by(Sort.Direction.ASC,fieldTwo):Sort.by(Sort.Direction.DESC,fieldTwo);
		Sort sort = sortOne.and(sortTwo);
		
		
		return customerRepository.findAll(sort);
	}

	@Override
	public List<Customer> getCustomersPageWise(Integer pageNo, Integer pageSize) {
	   
		 Pageable pageable = PageRequest.of(pageNo, pageSize);
		 Page<Customer>  page = customerRepository.findAll(pageable);
		 
		 if(page.hasContent()) {
			 return page.getContent();
		 }
		 
		 throw new CustomerNotFoundException("Customer not found for the request page size "+pageSize+" and pageNo "+ pageNo);
	}

	@Override
	public List<Customer> getSortedAndPaginated(String fieldOne, String dirOne, String fieldTwo, String dirTwo,
		   Integer pageNo, Integer pageSize) {
		   Sort sortOne = dirOne.equalsIgnoreCase("ASC")?Sort.by(Sort.Direction.ASC,fieldOne):Sort.by(Sort.Direction.DESC,fieldOne);
	       Sort sortTwo = dirTwo.equalsIgnoreCase("ASC")?Sort.by(Sort.Direction.ASC,fieldTwo):Sort.by(Sort.Direction.DESC,fieldTwo);
	       Sort sort = sortOne.and(sortTwo);
	       
	       Pageable pageable = PageRequest.of(pageNo, pageSize,sort);
			 Page<Customer>  page = customerRepository.findAll(pageable);
			 
			 if(page.hasContent()) {
				 return page.getContent();
			 }
			 
			 throw new CustomerNotFoundException("Customer not found for the request page size "+pageSize+" and pageNo "+ pageNo);
	        
		   
	}

 
 
 
 
 
 */

















