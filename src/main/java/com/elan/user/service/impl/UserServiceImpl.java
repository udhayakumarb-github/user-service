package com.elan.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.elan.user.repo.UserDao;
import com.elan.user.repo.model.UserEntity;
import com.elan.user.service.UserService;
import com.elan.user.service.mapper.Mapper;
import com.elan.user.service.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;
	
	@Autowired
	@Qualifier("userMapper")
	Mapper<User, UserEntity> userMapper;
	
	@Autowired
	@Qualifier("userListMapper")
	Mapper<List<User>, List<UserEntity>> userListMapper;
	
	@Override
	public User createOrUpdate(final User user) {
		return userMapper.mapEntityToDomain(userDao.save(userMapper.mapDomainToEntity(user)));
	}

	@Override
	public User getUser(final Integer userId) {
		
		UserEntity userEntity = userDao.fetchByUserId(userId);
		
		if (userEntity == null) {
			throw new RuntimeException("User not found");
		}
		
		return userMapper.mapEntityToDomain(userEntity);
	}

	@Override
	public List<User> getAllUsers() {
		return userListMapper.mapEntityToDomain(userDao.fetchAll());
	}

}
