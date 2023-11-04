package com.masaischool.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masaischool.model.Item;
import com.masaischool.service.ItemService;
import lombok.extern.slf4j.Slf4j; // Import Lombok's SLF4J annotation

import jakarta.validation.Valid;

@RestController
@Slf4j // Add the Lombok annotation
public class ItemController {

    @Autowired
    ItemService itemService;

    @PostMapping("/items")
    public ResponseEntity<List<Item>> addItem(@Valid @RequestBody List<Item> items) {
        
        log.info("Received a request to add list of items: {}", items);
        for(Item item:items) {
        	
             itemService.saveItem(item);
        }
        
        return new ResponseEntity<List<Item>>(items, HttpStatus.OK);
    }

//    @PostMapping("/items/{itemId}/{orderId}/{restaurantId}")
//    public ResponseEntity<Item> assignItemToOrder(@PathVariable Integer itemId, @PathVariable Integer orderId,@PathVariable Integer restaurantId) {
//      
//        log.info("Received a request to add an item with itemId {} to orderId {}", itemId, orderId);
//
//        return new ResponseEntity<Item>(itemService.addItemsToOrder(itemId, orderId,restaurantId), HttpStatus.OK);
//    }
}
