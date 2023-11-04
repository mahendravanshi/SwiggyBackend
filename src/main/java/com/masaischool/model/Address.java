package com.masaischool.model;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Address {

	@NotBlank
	private String city;
	@NotBlank
	private String state;
	
	@NotBlank
	@Pattern(regexp="^[1-9][0-9]{5}$",message="pleae write zipcode in correct format")
	private String zipCode;
	
	
}




