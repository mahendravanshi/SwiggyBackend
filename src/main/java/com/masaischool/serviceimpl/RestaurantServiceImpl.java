package com.masaischool.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import com.masaischool.model.Restaurant;
import com.masaischool.repository.RestaurantRepository;
import com.masaischool.service.RestaurantService;

@Service
public class RestaurantServiceImpl implements RestaurantService {
	
	@Autowired
	private RestaurantRepository restaurantRepository;

	@Override
	public Restaurant addRestaurant(Restaurant res) {

		restaurantRepository.save(res);
         
		return res;
	}

	
//	@Override
//	public List<Restaurant> getAllRestaurants() {
//		
//		List<Restaurant> list = restaurantRepository.findAll();
//		if(list.size()==0) {
//			throw new RestaurantNotFoundException("No restaurant found in the database");
//		}
//		return list;
//	}
//
//	@Override
//	public Restaurant getRestaurantById(Integer id) {
//		
//		return restaurantRepository.findById(id).orElseThrow(()->new RestaurantNotFoundException("No restaurant with restaurant id "+id+" found"));
//	}
//
//	@Override
//	public List<Restaurant> getSortedRestaurants(String fieldOne, String dirOne, String fieldTwo, String dirTwo) {
//		Sort sortOneSort = dirOne.equalsIgnoreCase("ASC")?Sort.by(Sort.Direction.ASC,fieldOne):Sort.by(Sort.Direction.DESC,fieldOne);
//		Sort sortTwoSort = dirTwo.equalsIgnoreCase("ASC")?Sort.by(Sort.Direction.ASC,fieldTwo):Sort.by(Sort.Direction.DESC,fieldTwo);
//		
//		Sort sort = sortOneSort.and(sortTwoSort);
//		return  restaurantRepository.findAll(sort);
//	}
//	
//
//	@Override
//	public List<Restaurant> getRestaurantsPageWise(Integer pageNo, Integer pageSize) {
//		Pageable pageable = PageRequest.of(pageNo, pageSize);
//		 Page<Restaurant>  page = restaurantRepository.findAll(pageable);
//		 
//		 if(page.hasContent()) {
//			 return page.getContent();
//		 }
//		 
//		 throw new RestaurantNotFoundException("Restaurant not found for the request page size "+pageSize+" and pageNo "+ pageNo);
//	}
//	
//	
	

}
