package com.elan.user.service;

import java.util.List;

import com.elan.user.service.model.User;

public interface UserService {

	User createOrUpdate(final User user);
	
	User getUser(final Integer userId);
	
	List<User> getAllUsers();
}
