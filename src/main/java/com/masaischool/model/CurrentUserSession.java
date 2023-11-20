package com.masaischool.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class CurrentUserSession {
	
	@Id
	private Integer customerId;

	private String type;
	
	private String uuid;
	
	@CreationTimestamp
	private LocalDateTime localDateTime;
	
}
