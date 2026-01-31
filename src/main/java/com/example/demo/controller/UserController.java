package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.UserDTO;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	@Qualifier("userService")
	private UserService userService;
	
	@GetMapping
	public ResponseEntity<?> getAllUsers(){
		List<UserDTO> users = userService.listAllUsers();
		return ResponseEntity.ok(users);
		
	}
	
	

}
