package com.masaischool.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masaischool.model.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {

	
}
