package com.masaischool.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.masaischool.model.Order;

@Service
public interface OrderService {

     public  Order placeOrder(Integer customerId, Integer restaurantId, List<Integer> itemIds);
     
     

	public Order assignDeliveryPartenerToOrder(Integer deliveryPartenerId,Integer orderId);
	
	public Order updateOrderStatus(Integer orderId,String orderStatus);
	
	
	public List<Order> fetchCustomersOrdersHistorySortedAndPaginated(Integer customerId,String fieldOne, String dirOne, String fieldTwo, String dirTwo,Integer pageNo, Integer pageSize);

	
//	public List<Order> fetchCustomersOrdersHistorySortedAndPaginated(Integer customerId);
    
	
	//	public List<Order> getAllOrders();
	
//	public Order getOrderById(Integer id);
//	
//	
//	
	
//
//	public List<Order> getSortedOrders(String fieldOne, String dirOne, String fieldTwo, String dirTwo);
//
//	public List<Order> getOrdersPageWise(Integer pageNo, Integer pageSize);

	
	
}
