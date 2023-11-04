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

import com.masaischool.model.DeliveryPartener;
import com.masaischool.service.DeliveryPartenerService;

import jakarta.validation.Valid;

@RestController
public class DeliveryPartenerController {

	
	@Autowired
	private DeliveryPartenerService deliveryPartenerService;
	
	@PostMapping("/addDeliveryParteners") 
	
	public ResponseEntity<List<DeliveryPartener>> addDeliveryPartener(@Valid @RequestBody List<DeliveryPartener> deliveryParteners){
		
		
		    for(DeliveryPartener deliveryPartener : deliveryParteners) {
		    	
		    	deliveryPartenerService.addDeliveryPartener(deliveryPartener);
		    }
		    
		    
		return new ResponseEntity<>(deliveryParteners,HttpStatus.CREATED);
	}
	
	
    
	
	
}
































/*


	@GetMapping("/deliveryParteners/{deliveryPartenerId}")
    public ResponseEntity<DeliveryPartener> getDeliveryPartenerById(@PathVariable Integer deliveryPartenerId){
		
		return new ResponseEntity<DeliveryPartener>(deliveryPartenerService.getDeliveryPartenerById(deliveryPartenerId),HttpStatus.OK);
	}
	
	@GetMapping("/deliveryParteners")
	
    public ResponseEntity<List<DeliveryPartener>> getAllDeliveryParteners(){
		
		return new ResponseEntity<>(deliveryPartenerService.getAllDeliveryParteners(),HttpStatus.OK);
	}
	
	@GetMapping("/sortDeliveryPartener/{fieldOne}/{dirOne}/{fieldTwo}/{dirTwo}")
	public ResponseEntity<List<DeliveryPartener>> getSortedDeliveryPartener(@PathVariable String fieldOne,@PathVariable String dirOne,
			@PathVariable String fieldTwo,@PathVariable String dirTwo){
		
		return new ResponseEntity<List<DeliveryPartener>>(deliveryPartenerService.getSortedDeliveryPartener(fieldOne,dirOne,fieldTwo,dirTwo),HttpStatus.OK);
	}
	
	@GetMapping("/getDeliveryPartenerPageWise/{pageNo}/{pageSize}")
	ResponseEntity<List<DeliveryPartener>> getSortedDeliveryPartener(@PathVariable Integer pageNo,@PathVariable Integer pageSize
		){
		
		return new ResponseEntity<List<DeliveryPartener>>(deliveryPartenerService.getDeliveryPartenerPageWise(pageNo,pageSize),HttpStatus.OK);
	}


*/