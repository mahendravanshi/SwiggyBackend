package com.masaischool.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masaischool.exception.NoItemFoundException;
import com.masaischool.exception.OrderNotFoundException;
import com.masaischool.model.Item;
import com.masaischool.model.Order;
import com.masaischool.repository.ItemRepository;
import com.masaischool.repository.OrderRepository;
import com.masaischool.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	private ItemRepository itemRepository;
	

    
	@Override
	public Item saveItem(Item item) {
		
		itemRepository.save(item);
		
		return item;
		
	}

//	@Override
//	public Item addItems(Integer itemId, Integer orderId) {
//		
//		Order o = orderRepository.findById(orderId).orElseThrow(()->new OrderNotFoundException("No order found to add item with order id "+orderId));
//		Item item = itemRepository.findById(itemId).orElseThrow(()-> new NoItemFoundException("item not found"));
//		
//		o.getItems().add(item);
//		
//		orderRepository.save(o);
//		
//		
//		return item;
//	}
//
//	@Override
//	public Item addItemsToOrder(Integer itemId, Integer orderId, Integer restaurantId) {
//		
//		return null;
//	}

}
