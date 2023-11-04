package com.masaischool.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Item {

	
	  @Id
	  @GeneratedValue(strategy=GenerationType.IDENTITY)
	  private Integer itemId;
	  
	  
	  @NotBlank(message="Item name required")
	  private String name;
	  
      
	  @Min(value=1L,message="Minimum price should be greater than or equal to 1")
	  private Double price;
	  
	  @NotBlank(message="Item description required")
	  private String description;
	  
	  @NotBlank(message="item image required")
	  private String imageUrl;
	  
	  
	  @ManyToOne
	  @JsonIgnore
	  @JoinColumn(name="restaurant_id")
	  private Restaurant restaurant;
	  
	  
	  @ManyToOne
	  @JsonIgnore
	  private Order order;
	  
	  
}
