package com.masaischool.model;



import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class AdminDTO {
	@NotNull(message ="Username cannot be null.")
	private String username;
	@NotNull(message ="Password cannot be null.")
	private String password;
}

