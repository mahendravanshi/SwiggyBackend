package com.masaischool.service;




import java.util.List;


import com.masaischool.model.Customer;

public interface CustomerService {

	
	public Customer addCustomer(Customer c);
    
	
	Customer updateCustomer(Customer customer, String uuid);
	
	
	public Customer deleteCustomer(Integer customerId,String uuid);
	
	public Customer viewCustomer(Integer customerId,String uuid);

	
	public List<Customer> viewAllCustomers(String uuid);


	
	
	
	
	

}

































/*

 public List<Customer> getAllCustomers();

	public Customer getCustomerById(Integer id);

	public List<Customer> getSortedCustomers(String fieldOne, String dirOne, String fieldTwo, String dirTwo);

	public List<Customer> getCustomersPageWise(Integer pageNo, Integer pageSize);

	public List<Customer> getSortedAndPaginated(String fieldOne, String dirOne, String fieldTwo, String dirTwo,
			Integer pageNo, Integer pageSize);
 */

 
