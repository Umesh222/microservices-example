package com.umesh.microservices.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.umesh.microservices.example.model.User;
import com.umesh.microservices.example.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	
	public void saveUser(User user) {
		
	userRepository.save(user);	
	}

	public Page<User> getUsers(int pageNo,int pageSize){
		Pageable paging = PageRequest.of(pageNo, pageSize);
		 
		 return  userRepository.findAll(paging);
			
	}
	
	
}
