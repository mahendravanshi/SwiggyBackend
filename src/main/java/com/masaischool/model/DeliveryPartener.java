package com.masaischool.model;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryPartener {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="delivery_partener_id",nullable=false)
//	@Min(value=1L,message="id should be greater than 0")
	private Integer deliveryPartenerId ;
	
	@NotBlank(message="name be null or empty")
	@Column(name="name",nullable=false)
	private String name;
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "deliveryPartener", cascade = CascadeType.ALL)
	private List<Order> orders;
    
	
	
	@NotBlank(message="phone number cannot be null or empty")
	@Pattern(regexp = "^[6-9][0-9]{9}$",message="Pleae enter correct 10 digit mobile number")
	@Column(name="phone_number",nullable=false)
	private String phoneNumber;

	
	
}


//unique deliveryPartnerId, name, and phone number.