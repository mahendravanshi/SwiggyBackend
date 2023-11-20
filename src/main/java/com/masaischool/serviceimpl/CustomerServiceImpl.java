package com.masaischool.serviceimpl;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masaischool.exception.CustomerNotFoundException;
import com.masaischool.exception.LoginException;
import com.masaischool.model.CurrentUserSession;
import com.masaischool.model.Customer;
import com.masaischool.repository.CurrentUserSessionRepo;
import com.masaischool.repository.CustomerRepository;
import com.masaischool.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	
	@Autowired
	private CurrentUserSessionRepo currentUserSessionRepo;

	@Override
	public Customer addCustomer(Customer c) {
		
		
		customerRepository.save(c);

		return c;
	}

	@Override
	public Customer updateCustomer(Customer customer, String uuid) {
		
		
		CurrentUserSession currentUserSession  = currentUserSessionRepo.findByUuid(uuid).orElseThrow(()->new LoginException("not logged in"));
		if(currentUserSession==null) {
			throw new CustomerNotFoundException("Invalid uuid entered");
		}
		
		if(currentUserSession.getCustomerId()!=customer.getCustomerId()) {
			throw new CustomerNotFoundException("unauthorized to update details of user");
		}
		
		
		customerRepository.save(customer);
		
		return customer;
		
		
	}

	@Override
	public Customer deleteCustomer(Integer customerId, String uuid) {
		
		
		Customer customer = customerRepository.findById(customerId).orElseThrow(()->new CustomerNotFoundException("Invalid customer id"));
		Integer cusIdInteger = currentUserSessionRepo.findByUuid(uuid).get().getCustomerId();
		
		if(cusIdInteger==null) {
			throw new CustomerNotFoundException("Invalid uuid entered");
		}
		if(cusIdInteger!=customerId) {
			throw new CustomerNotFoundException("Invalid access cannot delete");
		}
		
		customerRepository.deleteById(customerId);
		currentUserSessionRepo.deleteById(cusIdInteger);
		
		return customer;
	}

	@Override
	public Customer viewCustomer(Integer customerId, String uuid) {
		
		   Optional<CurrentUserSession> currentUserSession = currentUserSessionRepo.findByUuid(uuid);
		
		if(currentUserSession==null) {
			throw new CustomerNotFoundException("Invalid uuid entered");
		}
		if(currentUserSession.get().equals("admin"))
		{
			Customer customer = customerRepository.findById(customerId).orElseThrow(()->new CustomerNotFoundException("No customer found with id "+customerId));
			
			return customer;
			
		}
		
		Customer customer = customerRepository.findById(customerId).orElseThrow(()->new CustomerNotFoundException("No customer found with id "+customerId));
        
		 if(customer.getCustomerId()!=currentUserSession.get().getCustomerId() || customer==null) {
			 throw new CustomerNotFoundException("Invalid access ");
		 }
		 
		 return customer;
		 
	}

	@Override
	public List<Customer> viewAllCustomers(String uuid) {
		
		 
		String typeString = currentUserSessionRepo.findByUuid(uuid).get().getType();
		if(typeString.equals("admin")) {
			return customerRepository.findAll();
		}
		
		else {
			throw new CustomerNotFoundException("You are not an admin to access data");
		}
		
		
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

















