package com.masaischool.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masaischool.model.Order;
import com.masaischool.service.OrderService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@PostMapping("placeOrder/customerId/{customerId}/restaurantId/{restaurantId}")
	public Order placeOrder(@RequestBody List<Integer> itemIds, @RequestParam Integer customerId,
			@RequestParam Integer restaurantId) {
        
		return orderService.placeOrder(customerId, restaurantId, itemIds);
		
	}
	
	
//	@GetMapping("orders/{orderId}")
//    public ResponseEntity<Order> getOrderById(@PathVariable Integer orderId){
//		
//		return new ResponseEntity<Order>(orderService.getOrderById(orderId),HttpStatus.OK);
//	}
//	
//	@GetMapping("orders")
//	
//    public ResponseEntity<List<Order>> getAllorders(){
//		
//		return new ResponseEntity<>(orderService.getAllOrders(),HttpStatus.OK);
//	}
//	
	// assign deliveryPArtenerToOrder
	
	@PatchMapping("orders/assignDpToOrder/deliveryPartener/{deliveryPartenerId}/order/{orderId}")
	public ResponseEntity<Order> assignDpToOrder(@Valid @PathVariable Integer deliveryPartenerId,@Valid @PathVariable Integer orderId){
		
		return new ResponseEntity<Order>(orderService.assignDeliveryPartenerToOrder(deliveryPartenerId, orderId),HttpStatus.OK); 
	}
	
	
	
	
	//updateOrder Status
	
	@PatchMapping("order/updateOrderStatus/order/{orderId}/status/{orderStatus}")
	public ResponseEntity<Order> updateOrderStatus(@PathVariable Integer orderId,@PathVariable String orderStatus){
		
		     return new ResponseEntity<Order>(orderService.updateOrderStatus(orderId, orderStatus),HttpStatus.OK);
	}
	

	
	@GetMapping("fetchCustomersOrderHistory/customer/{customerId}/{fieldOne}/{dirOne}/{fieldTwo}/{dirTwo}/{pageNo}/{pageSize}")
	public ResponseEntity<List<Order>> fetchCustomersOrdersHistorySortedAndPaginated(Integer customerId, @PathVariable String fieldOne,@PathVariable String dirOne,
			@PathVariable String fieldTwo,@PathVariable String dirTwo, @PathVariable Integer pageNo,@PathVariable Integer pageSize){
	
	    
	       return new ResponseEntity<List<Order>>(orderService.fetchCustomersOrdersHistorySortedAndPaginated(customerId, fieldOne, dirOne, fieldTwo, dirTwo, pageNo, pageSize),HttpStatus.OK);
	
	         
     }

     
      
//     @GetMapping("simpleFetch/{customerId}")
//     public ResponseEntity<List<Order>> getOrdersOfCustomer(@PathVariable Integer customerId){
//    	
//    	 return new ResponseEntity<List<Order>>(orderService.fetchCustomersOrdersHistorySortedAndPaginated(customerId),HttpStatus.OK) ;
//     }
	
//	
//	@GetMapping("sortOrders/{fieldOne}/{dirOne}/{fieldTwo}/{dirTwo}")
//	public ResponseEntity<List<Order>> getSortedOrders(@PathVariable String fieldOne,@PathVariable String dirOne,
//			@PathVariable String fieldTwo,@PathVariable String dirTwo){
//		
//		return new ResponseEntity<List<Order>>(orderService.getSortedOrders(fieldOne,dirOne,fieldTwo,dirTwo),HttpStatus.OK);
//	}
//	
//	@GetMapping("getOrdersPageWise/{pageNo}/{pageSize}")
//	ResponseEntity<List<Order>> getSortedOrders(@PathVariable Integer pageNo,@PathVariable Integer pageSize
//		){
//		
//		return new ResponseEntity<>(orderService.getOrdersPageWise(pageNo,pageSize),HttpStatus.OK);
//	}
     
     
     
     

}
