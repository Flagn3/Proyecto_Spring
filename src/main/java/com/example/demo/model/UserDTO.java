package com.example.demo.model;

import java.util.List;

import com.example.demo.entity.Booking;

import jakarta.persistence.CascadeType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

public class UserDTO {

	private int id;
	
	private String name;
	
	private String secondName;
	
	private String email;
	
	private String username;
	
	private String img;
	
	private String password;
	
	private String role;
	
	private boolean activated;
	
	private boolean deleted;
	
	private List<Booking> bookings;
}
