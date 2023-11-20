package com.masaischool.serviceimpl;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.masaischool.enums.OrderStatus;
import com.masaischool.exception.CustomerNotFoundException;
import com.masaischool.exception.DeliveryPartenerNoFoundException;
import com.masaischool.exception.InvalidStateException;
import com.masaischool.exception.NoItemFoundException;
import com.masaischool.exception.OrderNotFoundException;
import com.masaischool.exception.RestaurantNotFoundException;
import com.masaischool.model.Customer;
import com.masaischool.model.DeliveryPartener;
import com.masaischool.model.Item;
import com.masaischool.model.Order;
import com.masaischool.model.Restaurant;
import com.masaischool.repository.CustomerRepository;
import com.masaischool.repository.DeliveryPartenerRepository;
import com.masaischool.repository.ItemRepository;
import com.masaischool.repository.OrderRepository;
import com.masaischool.repository.RestaurantRepository;
import com.masaischool.service.OrderService;



@Service
public class OrderServiceImpl implements OrderService {
	
	
	private OrderRepository orderRepository;
	private DeliveryPartenerRepository deliveryPartenerRepository;
	private CustomerRepository customerRepository;
	private RestaurantRepository restaurantRepository;
	private ItemRepository itemRepository;
	
	


	public OrderServiceImpl(OrderRepository orderRepository, DeliveryPartenerRepository deliveryPartenerRepository,
			CustomerRepository customerRepository, RestaurantRepository restaurantRepository,ItemRepository itemRepository) {
		super();
		this.orderRepository = orderRepository;
		this.deliveryPartenerRepository = deliveryPartenerRepository;
		this.customerRepository = customerRepository;
		this.restaurantRepository = restaurantRepository;
		this.itemRepository = itemRepository;
	}

   
//	private List<OrderStatus> orderStatus;
	
	
	
	
	   
	@Override
	public Order updateOrderStatus(Integer orderId, String orderStatus) {
		
		  Order order = orderRepository.findById(orderId).orElseThrow(()->new OrderNotFoundException("Order not found with order id "+orderId+" to assign to delivery parntner"));
		  if(order==null) {
			  throw new OrderNotFoundException("No order found with order id "+ orderId+"  to update order Status");
		  }
		  
		  OrderStatus uppercaseStatus = OrderStatus.valueOf(orderStatus.toUpperCase());
		  
		  if(order.getOrderStatus().equals(OrderStatus.DELIVERED)) {
			  throw new InvalidStateException("Cannot update delivery status of Delivered Order");
		  }
		  
		  
       order.setOrderStatus(uppercaseStatus);
		 
       orderRepository.save(order);
		  
		return order;
	}

	@Override
	public Order assignDeliveryPartenerToOrder(Integer deliveryPartenerId, Integer orderId) {
		
		  DeliveryPartener deliveryPartener = deliveryPartenerRepository.findById(deliveryPartenerId).orElseThrow(()->new DeliveryPartenerNoFoundException("No delivery partener found with id "+deliveryPartenerId+" to assign to order"));
		  Order order = orderRepository.findById(orderId).orElseThrow(()->new OrderNotFoundException("Order not found with order id "+orderId+" to assign to delivery parntner"));
		  
		  if(order.getDeliveryPartener()!=null) {
			  throw new InvalidStateException("Order is already assigned to a delivery partener");
		  }
		  
		  if(order.getOrderStatus()==OrderStatus.DELIVERED) {
			  throw new InvalidStateException("Order is already delivered");
		  }
		  
		  deliveryPartener.getOrders().add(order);
		  order.setDeliveryPartener(deliveryPartener);
		  
		  deliveryPartenerRepository.save(deliveryPartener);
		  
		  return order;
	}

	

	@Override
	public Order placeOrder(Integer customerId, Integer restaurantId, List<Integer> itemIds) {
		
		Customer customer = customerRepository.findById(customerId).orElseThrow(()->new CustomerNotFoundException("Customer not found with customer id "+customerId));
		Restaurant restaurant = restaurantRepository.findById(restaurantId).orElseThrow(()->new RestaurantNotFoundException("resuturant not found with customer id "+restaurantId));
		
		Order order = new Order();
		order.setCustomer(customer);
		order.setRestaurant(restaurant);
		order.setDeliveryPartener(null);
		order.setOrderStatus(OrderStatus.COOKING);
		
		
		List<Item> items = new ArrayList<>();
		
		for(Integer  itemId : itemIds) {
			
			Item item = itemRepository.findById(itemId).orElseThrow(()->new NoItemFoundException("No item found with item id "+itemId+" to add in order .Please place fresh order"));
		    item.setRestaurant(restaurant);
		    order.getItems().add(item);
		    item.getOrders().add(order);
            
		    items.add(item);
			
		}
		
		Double tpDouble = items.stream().mapToDouble(x->x.getPrice()) .reduce(0.0,(x,y)->x+y);
		
		order.setItems(items);
		order.setTotalPriceDouble(tpDouble);  // order all set
		
		
		customer.getOrders().add(order);  // customers all set
		
		Customer customer2 = 	customerRepository.save(customer);  // order ->(items) will be automatically saved
		
		
		
		System.out.println("customer2  "+customer2.getOrders());
		
		
		restaurant.setItems(items);
		restaurant.getOrders().add(order);  //restaurant all set
		
		restaurantRepository.save(restaurant);
		   //order and items will be automatically saved due to cascadeType.ALL
		
        
		return order;
		
	}

     

	@Override
	public List<Order> fetchCustomersOrdersHistorySortedAndPaginated(Integer customerId, String fieldOne, String dirOne,
			String fieldTwo, String dirTwo, Integer pageNo, Integer pageSize) {
		
		
		  Sort s1 = dirOne.equalsIgnoreCase("asc")?Sort.by(Sort.Direction.ASC,fieldOne):Sort.by(Sort.Direction.DESC,fieldOne);
		  Sort s2 = dirTwo.equalsIgnoreCase("asc")?Sort.by(Sort.Direction.ASC,fieldTwo):Sort.by(Sort.Direction.DESC,fieldTwo);
		  
		  
		  Sort sort = s1.and(s2);
		  Pageable pageable = PageRequest.of(pageNo, pageSize,sort);
		  
		  
		  
		  
		  Page<Order> page = orderRepository.fetchCustomersOrdersHistorySortedAndPaginated(customerId, pageable);
		  
		  
		  if(page.hasContent()) {
			  return  page.getContent();
		  }
		  else {
			  
			  throw new NoItemFoundException("No content found for the request page");
		  }
		
		  
		  
	}
     
   
   



	

	
	
	
	

	

	
	


	
	
}

























/*

@Override
	public List<Order> getAllOrders() {
		
		List<Order> list = orderRepository.findAll();
		
		if(list.size()==0) {
			throw new OrderNotFoundException("No orders foundin the database");
		}
		
		return list;
	}

	@Override
	public Order getOrderById(Integer id) {
		
		return orderRepository.findById(id).orElseThrow(()->new OrderNotFoundException("No order found with order id "+id));
	}

	
	
	

	@Override
	public List<Order> fetchCustomersOrdersHistory(Integer customerId) {
		
		return null;
		 
	}


	@Override
	public List<Order> getSortedOrders(String fieldOne, String dirOne, String fieldTwo, String dirTwo) {
		Sort sortOneSort = dirOne.equalsIgnoreCase("ASC")?Sort.by(Sort.Direction.ASC,fieldOne):Sort.by(Sort.Direction.DESC,fieldOne);
		Sort sortTwoSort = dirTwo.equalsIgnoreCase("ASC")?Sort.by(Sort.Direction.ASC,fieldTwo):Sort.by(Sort.Direction.DESC,fieldTwo);
		
		Sort sort = sortOneSort.and(sortTwoSort);
		
		return orderRepository.findAll(sort);
		
		
	}


	@Override
	public List<Order> getOrdersPageWise(Integer pageNo, Integer pageSize) {
		
		    PageRequest pageable  = PageRequest.of(pageNo,pageSize);
		    
		    Page<Order> page = orderRepository.findAll(pageable);
		    
		    if(page.hasContent()) {
		    	return page.getContent();
		    }
		    
		    throw new OrderNotFoundException(" No order for  request page size "+pageSize+" and pageNo "+ pageNo);
	}


*/