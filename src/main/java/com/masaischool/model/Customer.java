package com.masaischool.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

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
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="customer_id",nullable=false)
	private Integer customerId;
	
	
	@NotBlank(message="customer name cannot be null or empty")
	@Column(name="customer_name",nullable=false)
	private String customerName;
	
	@NotBlank(message="Email cannot be null or empty")
	@Column(name="email",nullable=false,unique=true)
	@Pattern(regexp="^[a-zA-Z0-9.]+@[a-zA-Z0-9.]+\\.[a-zA-Z]{2,}$",message="Email not valid")
	private String email;
	
	
	@NotBlank
	@Column(nullable=false,unique=true)
	private String username;
	
	@NotBlank
	@Pattern(regexp="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*=])")
	@JsonProperty(access=Access.WRITE_ONLY)
	private String password;
	
	
	@Embedded
	@Valid
	private Address address;
	
	
	@OneToMany(mappedBy="customer",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JsonIgnore
	private List<Order> orders;
    
    
	
}

//Customer: The Customer entity should have a unique customerId, name, email, and address.
