package com.elan.user.service.mapper;

public interface Mapper<U, V> {

	V mapDomainToEntity(final U u);
	
	U mapEntityToDomain(final V v);
}
