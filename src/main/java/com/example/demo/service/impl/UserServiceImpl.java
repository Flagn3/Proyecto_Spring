package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.model.UserDTO;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	@Qualifier("userRepository")
	private UserRepository userRepository;

	/**
	 * List all Users
	 */
	@Override
	public List<UserDTO> listAllUsers() {
		List<UserDTO> usersDTO = new ArrayList<>();
		for (User user : userRepository.findAll()) {
			usersDTO.add(transform(user));
		}
		return usersDTO;
	}

	/**
	 * Find User by its Id
	 */
	@Override
	public UserDTO getUserById(int id) {
		UserDTO userDTO = transform(
				userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found")));
		return userDTO;
	}

	@Override
	public User updateUser(Long id, UserDTO userDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteUser(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int activateUser(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deactivateUser(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Transform entity to model
	 * 
	 * @param court
	 * @return
	 */
	private UserDTO transform(User user) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(user, UserDTO.class);
	}

	/**
	 * Transform model to entity
	 * 
	 * @param courtDTO
	 * @return
	 */
	private User transform(UserDTO userDTO) {

		ModelMapper modelMapper = new ModelMapper();
		User user = modelMapper.map(userDTO, User.class);

		return user;

	}

}
