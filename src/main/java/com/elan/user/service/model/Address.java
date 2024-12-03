package com.elan.user.service.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Address {

	private Integer addressId;
	
	@NotBlank
	private String doorOrFlatNo;
	
	@NotBlank
	private String street;
	
	private String village;
	
	@NotBlank
	private String city;
	
	@NotBlank
	private String state;
	
	@NotBlank
	private String pinCode;
	
	@NotNull
	private boolean primary;
}
