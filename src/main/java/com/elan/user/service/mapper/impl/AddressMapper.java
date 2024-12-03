package com.elan.user.service.mapper.impl;

import org.springframework.stereotype.Component;

import com.elan.user.repo.model.AddressEntity;
import com.elan.user.service.mapper.Mapper;
import com.elan.user.service.model.Address;

@Component("addressMapper")
public class AddressMapper implements Mapper<Address, AddressEntity> {

	@Override
	public AddressEntity mapDomainToEntity(final Address address) {
		if (address == null) {
			return null;
		}
		
		return AddressEntity.builder()
				.addressId(address.getAddressId())
				.doorOrFlatNo(address.getDoorOrFlatNo())
				.street(address.getStreet())
				.village(address.getVillage())
				.city(address.getCity())
				.state(address.getState())
				.pinCode(address.getPinCode())
				.primary(address.isPrimary())
				.build();
	}

	@Override
	public Address mapEntityToDomain(final AddressEntity addressEntity) {
		
		if (addressEntity == null) {
			return null;
		}
		
		return Address.builder()
				.addressId(addressEntity.getAddressId())
				.doorOrFlatNo(addressEntity.getDoorOrFlatNo())
				.street(addressEntity.getStreet())
				.village(addressEntity.getVillage())
				.city(addressEntity.getCity())
				.state(addressEntity.getState())
				.pinCode(addressEntity.getPinCode())
				.primary(addressEntity.isPrimary())
				.build();
	}

}
