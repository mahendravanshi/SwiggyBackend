package com.masaischool.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masaischool.model.Restaurant;
import com.masaischool.service.RestaurantService;

import jakarta.validation.Valid;

@RestController
public class RestaurantController {

	
	@Autowired
	private RestaurantService restaurantService;
	
	@PostMapping("/restaurants")
	
	public ResponseEntity<List<Restaurant>> addRestaurant(@Valid @RequestBody List<Restaurant> restaurants){
		
		 for(Restaurant restaurant : restaurants) {
			 
			 restaurantService.addRestaurant(restaurant);
		 }
		
		 
		return new ResponseEntity<>(restaurants,HttpStatus.CREATED);
	}
     
//	@GetMapping("/restaurants/{restaurantId}")
//    public ResponseEntity<Restaurant> getRestaurantById(@PathVariable Integer restaurantId){
//		
//		return new ResponseEntity<Restaurant>(restaurantService.getRestaurantById(restaurantId),HttpStatus.OK);
//	}
//	
//	@GetMapping("/restaurants")
//	
//    public ResponseEntity<List<Restaurant>> getAllrestaurants(){
//		
//		return new ResponseEntity<>(restaurantService.getAllRestaurants(),HttpStatus.OK);
//	}
//	
//	
//	@GetMapping("/sortRestaurants/{fieldOne}/{dirOne}/{fieldTwo}/{dirTwo}")
//	public ResponseEntity<List<Restaurant>> getSortedRestaurants(@PathVariable String fieldOne,@PathVariable String dirOne,
//			@PathVariable String fieldTwo,@PathVariable String dirTwo){
//		
//		return new ResponseEntity<List<Restaurant>>(restaurantService.getSortedRestaurants(fieldOne,dirOne,fieldTwo,dirTwo),HttpStatus.OK);
//	}
//	
//	
//	
//	
//	@GetMapping("/getRestaurantsPageWise/{pageNo}/{pageSize}")
//	ResponseEntity<List<Restaurant>> getSortedRestaurants(@PathVariable Integer pageNo,@PathVariable Integer pageSize
//		){
//		
//		return new ResponseEntity<>(restaurantService.getRestaurantsPageWise(pageNo,pageSize),HttpStatus.OK);
//	}
//	
//	
//	
//	
	
	    
}
