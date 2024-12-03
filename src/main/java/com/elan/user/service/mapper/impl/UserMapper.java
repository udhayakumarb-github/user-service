package com.elan.user.service.mapper.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.elan.user.repo.model.AddressEntity;
import com.elan.user.repo.model.UserEntity;
import com.elan.user.service.mapper.Mapper;
import com.elan.user.service.model.Address;
import com.elan.user.service.model.User;

@Component("userMapper")
public class UserMapper implements Mapper<User, UserEntity> {

	@Autowired
	@Qualifier("addressListMapper")
	private Mapper<List<Address>, List<AddressEntity>> addressListMapper;
	
	@Override
	public UserEntity mapDomainToEntity(final User user) {
		
		if (user == null) {
			return null;
		}
		
		return UserEntity.builder()
				.userId(user.getUserId())
				.firstName(user.getFirstName())
				.lastName(user.getLastName())
				.dateOfBirth(new java.sql.Date(user.getDateOfBirth().getTime()))
				.email(user.getEmail())
				.phoneNumber(user.getPhoneNumber())
				.addresses(addressListMapper.mapDomainToEntity(user.getAddressDetails()))
				.build();
	}

	@Override
	public User mapEntityToDomain(final UserEntity userEntity) {
		
		if (userEntity == null) {
			return null;
		}
		
		return User.builder()
				.userId(userEntity.getUserId())
				.firstName(userEntity.getFirstName())
				.lastName(userEntity.getLastName())
				.dateOfBirth(new java.util.Date(userEntity.getDateOfBirth().getTime()))
				.email(userEntity.getEmail())
				.phoneNumber(userEntity.getPhoneNumber())
				.addressDetails(addressListMapper.mapEntityToDomain(userEntity.getAddresses()))
				.build();
	}

}
