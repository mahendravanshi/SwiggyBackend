package com.masaischool.serviceimpl;

import java.time.LocalDateTime;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masaischool.exception.CustomerNotFoundException;
import com.masaischool.exception.LoginException;
import com.masaischool.model.CurrentUserSession;
import com.masaischool.model.Customer;
import com.masaischool.model.LoginDTO;
import com.masaischool.repository.CurrentUserSessionRepo;
import com.masaischool.repository.CustomerRepository;
import com.masaischool.service.LoginDTOService;

import net.bytebuddy.utility.RandomString;
@Service
public class LoginDTOServiceImpl implements LoginDTOService {
	
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	CurrentUserSessionRepo currentUserSessionRepo;
	

	public Customer findByUserId(Integer userId) {
		
		
		return customerRepository.findById(userId).orElseThrow(()->new CustomerNotFoundException("No customer found with id "+userId));
		
	}
	

	@Override
	public CurrentUserSession loginInAccount(LoginDTO loginDto) {
		
		   Customer customer = findByUsername(loginDto.getUsername());
		   
		   
		   
		   Optional<CurrentUserSession> currentUserSession = currentUserSessionRepo.findById(customer.getCustomerId());
		   
		   if(currentUserSession.isPresent()) {
			     throw new CustomerNotFoundException("User is already logged in");
		   }
		   
		   if(loginDto.getUsername().equals(loginDto.getUsername())&&customer.getPassword().equals(loginDto.getPassword())) {
			   
			     CurrentUserSession cus = CurrentUserSession.builder().customerId(customer.getCustomerId()).type(customer.getCustomerName())
			    		 .localDateTime(LocalDateTime.now()).uuid(RandomString.make(6)).build();
			     
			     return cus;
			     
			     
		   }
		   
		   else {
				throw new LoginException("Please Enter a valid password");
			}
		  
	}

	
	@Override
	public String logoutFromAccount(String uuid) {
	
		   CurrentUserSession currentUserSession = currentUserSessionRepo.findByUuid(uuid).orElseThrow(()->new LoginException("User not logged in"));
		   
		   currentUserSessionRepo.delete(currentUserSession);
		   
		   return "Logged out successfully...";
		    
	}

     
	public Customer findByUsername(String username) {
		
		    Customer customer = customerRepository.findByUsername(username).orElseThrow(()->new CustomerNotFoundException("No customer found with email "+username));
		    		
		    return customer;
	}

}
