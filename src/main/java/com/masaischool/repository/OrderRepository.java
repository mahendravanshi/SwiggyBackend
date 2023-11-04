package com.masaischool.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.masaischool.model.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

	@Query("select o from Order o where o.customer.customerId = :customerId")
	public Page<Order> fetchCustomersOrdersHistorySortedAndPaginated(Integer customerId,Pageable pageable);
    
	 
	 
}







