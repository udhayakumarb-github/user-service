package com.elan.user.service.mapper.impl;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.elan.user.repo.model.AddressEntity;
import com.elan.user.service.mapper.Mapper;
import com.elan.user.service.model.Address;

@Component("addressListMapper")
public class AddressListMapper implements Mapper<List<Address>, List<AddressEntity>> {

	@Autowired
	@Qualifier("addressMapper")
	private Mapper<Address, AddressEntity> addressMapper;

	@Override
	public List<AddressEntity> mapDomainToEntity(final List<Address> addressList) {
		
		if (CollectionUtils.isEmpty(addressList)) {
			return Collections.emptyList();
		}
		
		return addressList.stream().map(addressMapper::mapDomainToEntity).collect(Collectors.toList());
	}

	@Override
	public List<Address> mapEntityToDomain(final List<AddressEntity> addressEntityList) {
		if (CollectionUtils.isEmpty(addressEntityList)) {
			return Collections.emptyList();
		}
		
		return addressEntityList.stream().map(addressMapper::mapEntityToDomain).collect(Collectors.toList());
	}
	
	
}
