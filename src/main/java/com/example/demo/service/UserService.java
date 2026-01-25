package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.User;
import com.example.demo.model.UserDTO;

public interface UserService {

	List<UserDTO> listAllUsers();

	UserDTO getUserById(int id);

	int updateUser(UserDTO userDTO);

	int deleteUser(int id);

	int activateUser(int id);

	int deactivateUser(int id);

}
