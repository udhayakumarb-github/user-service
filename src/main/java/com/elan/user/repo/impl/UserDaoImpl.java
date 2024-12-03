package com.elan.user.repo.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.elan.user.repo.UserDao;
import com.elan.user.repo.UserRepository;
import com.elan.user.repo.model.UserEntity;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserEntity save(UserEntity user) {
		return userRepository.save(user);
	}

	@Override
	public UserEntity fetchByUserId(Integer userId) {
		Optional<UserEntity> userEntityOptional =  userRepository.findById(userId);
		
		return userEntityOptional.isPresent() ? userEntityOptional.get() : null;
	}

	@Override
	public List<UserEntity> fetchAll() {
		return userRepository.findAll();
	}

	
}
