package com.masaischool.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.masaischool.exception.DeliveryPartenerNoFoundException;
import com.masaischool.model.DeliveryPartener;
import com.masaischool.repository.DeliveryPartenerRepository;
import com.masaischool.service.DeliveryPartenerService;


@Service
public class DeliveryPartenerServiceImpl implements DeliveryPartenerService {

	@Autowired
	private DeliveryPartenerRepository deliveryPartenerRepository;

	@Override
	public DeliveryPartener addDeliveryPartener(DeliveryPartener dp) {

		deliveryPartenerRepository.save(dp);

		return dp;
	}
   
//	@Override
//	public List<DeliveryPartener> getAllDeliveryParteners() {
//
//		List<DeliveryPartener> list = deliveryPartenerRepository.findAll();
//
//		if (list.size() == 0) {
//			throw new DeliveryPartenerNoFoundException("No delivery partener found list is empty");
//
//		}
//
//		return list;
//
//	}
//	
//	
//
//	@Override
//	public DeliveryPartener getDeliveryPartenerById(Integer id) {
//
//		return deliveryPartenerRepository.findById(id)
//				.orElseThrow(() -> new DeliveryPartenerNoFoundException("No delivery partener found with id " + id));
//	}
//
//	@Override
//	public List<DeliveryPartener> getSortedDeliveryPartener(String fieldOne, String dirOne, String fieldTwo,
//			String dirTwo) {
//		Sort s1 = dirOne.equalsIgnoreCase("ASC")?Sort.by(Sort.Direction.ASC,fieldOne):Sort.by(Sort.Direction.DESC,fieldOne);
//	    Sort s2 = dirTwo.equalsIgnoreCase("ASC")?Sort.by(Sort.Direction.ASC,fieldTwo):Sort.by(Sort.Direction.DESC,fieldTwo);
//		Sort sort = s1.and(s2);
//	    return deliveryPartenerRepository.findAll(sort);
//	}
//
//	@Override
//	public List<DeliveryPartener> getDeliveryPartenerPageWise(Integer pageNo, Integer pageSize) {
//		
//		Pageable pageable = PageRequest.of(pageNo, pageSize);
//	    
//	     Page<DeliveryPartener> page = deliveryPartenerRepository.findAll(pageable);
//	     
//	     if(page.hasContent()) {
//	    	 return page.getContent();
//	     }
//	     
//	     
//	     
//	     throw new DeliveryPartenerNoFoundException("No delivery partener found for the request page size "+pageSize+" and pageNo "+ pageNo);
//	}
//	
	
	
	

}
