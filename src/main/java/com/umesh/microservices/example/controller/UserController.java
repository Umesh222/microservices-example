package com.umesh.microservices.example.controller;

import java.util.List;

import org.apache.tomcat.util.http.parser.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.umesh.microservices.example.model.User;
import com.umesh.microservices.example.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	UserService userService;

	@PostMapping("/user")
	public Long saveUser(@RequestBody User user) {

		userService.saveUser(user);
		// System.out.println(user.getEmail());
		return user.getUserId();
	}

	@GetMapping("/userpage")
	public ResponseEntity<List<User>> getUsers(@RequestParam(value = "page") int page,
			@RequestParam(value = "limit") int limit) {
		Page<User> list = userService.getUsers(page, limit);
		System.out.println(list.getContent() + ">>>>>>>>>>>>?");
		return new ResponseEntity<List<User>>(list.getContent(), HttpStatus.CREATED);
	}

	@PutMapping("/user/{userid}")
	public User updateUser(@PathVariable("userid") long userid,@RequestBody User user) {
		
		return userService.updateUser(userid,user);
	}

	@DeleteMapping
	public String deleteUser() {

		return "tested...";
	}

	@GetMapping
	public String getUserList() {

		return "tested...";
	}

}
