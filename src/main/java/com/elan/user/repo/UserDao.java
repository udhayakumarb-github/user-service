package com.elan.user.repo;

import java.util.List;

import com.elan.user.repo.model.UserEntity;

public interface UserDao {

	UserEntity save(final UserEntity user);
	
	UserEntity fetchByUserId(final Integer userId);
	
	List<UserEntity> fetchAll();
}
