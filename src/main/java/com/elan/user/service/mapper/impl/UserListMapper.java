package com.elan.user.service.mapper.impl;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.elan.user.repo.model.UserEntity;
import com.elan.user.service.mapper.Mapper;
import com.elan.user.service.model.User;

@Component("userListMapper")
public class UserListMapper implements Mapper<List<User>, List<UserEntity>>{

	@Autowired
	@Qualifier("userMapper")
	private Mapper<User, UserEntity> userMapper;

	@Override
	public List<UserEntity> mapDomainToEntity(final List<User> u) {
		return null;
	}

	@Override
	public List<User> mapEntityToDomain(final List<UserEntity> userEntityList) {
		
		if (CollectionUtils.isEmpty(userEntityList)) {
			return Collections.emptyList();
		}
		
		return userEntityList.stream().map(userMapper::mapEntityToDomain).collect(Collectors.toList());
	}
	


}
