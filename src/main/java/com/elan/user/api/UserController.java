package com.elan.user.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elan.user.service.UserService;
import com.elan.user.service.model.User;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/v1/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping
	public ResponseEntity<User> createOrUpdate(@RequestBody @Valid final User userDetail) {
		
		return ResponseEntity.ok(userService.createOrUpdate(userDetail));
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<User> getUserDetail(@PathVariable("userId") final Integer userId) {
		
		return ResponseEntity.ok(userService.getUser(userId));
	}
	
	@GetMapping
	public ResponseEntity<List<User>> getAllUserDetails() {
		return ResponseEntity.ok(userService.getAllUsers());
	}
}
