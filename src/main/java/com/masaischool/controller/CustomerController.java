package com.masaischool.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masaischool.model.Customer;
import com.masaischool.service.CustomerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path="/")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@PostMapping("customers")
	
	public ResponseEntity<Customer> addCustomer(@Valid @RequestBody Customer c){
		
		return new ResponseEntity<>(customerService.addCustomer(c),HttpStatus.CREATED);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

//	@GetMapping("customers/{customerId}")
//    public ResponseEntity<Customer> getCustomerById(@PathVariable Integer customerId){
//		
//		return new ResponseEntity<Customer>(customerService.getCustomerById(customerId),HttpStatus.OK);
//	}
//	
//	@GetMapping("customers")
//	
//    public ResponseEntity<List<Customer>> getAllCustomers(){
//		
//		return new ResponseEntity<>(customerService.getAllCustomers(),HttpStatus.OK);
//	}
//	
//	
//	@GetMapping("sortCustomers/{fieldOne}/{dirOne}/{fieldTwo}/{dirTwo}")
//	public ResponseEntity<List<Customer>> getSortedCustomers(@PathVariable String fieldOne,@PathVariable String dirOne,@PathVariable String fieldTwo,@PathVariable String dirTwo){
//		
//		return new ResponseEntity<List<Customer>>(customerService.getSortedCustomers(fieldOne,dirOne,fieldTwo,dirTwo),HttpStatus.OK);
//	}
//	
//	@GetMapping("getCustomersPageWise/{pageNo}/{pageSize}")
//	ResponseEntity<List<Customer>> getSortedCustomers(@PathVariable Integer pageNo,@PathVariable Integer pageSize
//		){
//		
//		return new ResponseEntity<List<Customer>>(customerService.getCustomersPageWise(pageNo,pageSize),HttpStatus.OK);
//	}
//	
//	@GetMapping("sortAndPagination/{fieldOne}/{dirOne}/{fieldTwo}/{dirTwo}/{pageNo}/{pageSize}")
//	public ResponseEntity<List<Customer>> getSortedAndPaginatedCustomers(@PathVariable String fieldOne,@PathVariable String dirOne,
//			@PathVariable String fieldTwo,@PathVariable String dirTwo,@PathVariable Integer pageNo,@PathVariable Integer pageSize){
//		
//		return new ResponseEntity<List<Customer>>(customerService.getSortedAndPaginated(fieldOne,dirOne,fieldTwo,dirTwo,pageNo,pageSize),HttpStatus.OK);
//		
//	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	    
}
