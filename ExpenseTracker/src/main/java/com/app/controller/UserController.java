package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojo.User;
import com.app.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        userService.saveUser(user);
        return ResponseEntity.ok("User registered successfully.");
    }
	
	@GetMapping
	public ResponseEntity<?> getAllUser() {
		System.out.println("in fetch all users");
		List<User> userList = userService.getAllUser();
		// chk if empty
		if (userList.isEmpty())
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		// non empty list
		return new ResponseEntity<>(userList, HttpStatus.OK);
    }
	@GetMapping({"/{userId}"})
	public ResponseEntity<?> getUserById(@PathVariable int userId) {
		System.out.println("in get user dtls " + userId);
		try {
			return ResponseEntity.ok(userService.getUserById(userId));
		} catch (RuntimeException e) {
			System.out.println("err in controller " + e);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
	
	
}
