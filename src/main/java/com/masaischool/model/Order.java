package com.masaischool.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.masaischool.enums.OrderStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="orders")
@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class Order {
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="order_id",nullable=false)
//	@Min(value=1L,message="id should be greater than 0")
	private Integer orderId;
	
//	@Id
//	@GeneratedValue(strategy = GenerationType.UUID)
//	private UUID uuid; 
	
	
	
	@CreationTimestamp()
	@Column(name="order_date",updatable = false)
	private LocalDateTime orderDate;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	private List<Item> items;
	
	
	
	@NotNull(message = "order status cannot be null")
	@Enumerated(EnumType.STRING) // Use EnumType.STRING to store the enum as a string
	@Column(name = "order_status", nullable = false)
	private OrderStatus orderStatus;
	
	
	@Min(value=1L,message="Price cannot be less than 1")
	private Double totalPriceDouble;
    
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="customer_id")
	private Customer customer;
	
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="restaurant_id")
	private Restaurant restaurant;
    
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "delivery_partener_id", nullable = true)
	private DeliveryPartener deliveryPartener;
	
	
}


//Order: The Order entity should have a unique orderId, customerId, restaurantId, deliveryPartnerId (nullable), items 
//(a list of menu items), and orderStatus.