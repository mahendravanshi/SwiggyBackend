package com.masaischool.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Restaurant {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="restaurant_id",nullable=false)
	private Integer restaurantId;
	
	@NotBlank(message="restaurant name cannot be null or empty")
	@Column(name="restaurant_name",nullable=false)
	private String restaurantName;
	
	@Embedded
    @Valid
	private Address address;
	
	@OneToMany(mappedBy="restaurant",fetch=FetchType.EAGER)
	@JsonIgnore
	private List<Order> orders;
    
	
	@OneToMany(mappedBy="restaurant",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JsonIgnore
	private List<Item> items;
	
	
	
}


//Restaurant: The Restaurant entity should have a unique restaurantId, name, and address.
