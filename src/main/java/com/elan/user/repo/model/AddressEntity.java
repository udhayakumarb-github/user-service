package com.elan.user.repo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ADDRESS_DETAIL")
public class AddressEntity {

	@Id
	@Column(name = "ADDRESS_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer addressId;
	
	@Column(name = "DOOR_FLAT_NUM")
	private String doorOrFlatNo;
	
	@Column(name = "STREET")
	private String street;
	
	@Column(name = "VILLAGE")
	private String village;
	
	@Column(name = "CITY")
	private String city;
	
	@Column(name = "STATE")
	private String state;
	
	@Column(name = "PINCODE")
	private String pinCode;
	
	@Column(name = "IS_PRIMARY")
	private boolean primary;
	
	@Column(name = "USER_ID")
	private String userId;
	
}
