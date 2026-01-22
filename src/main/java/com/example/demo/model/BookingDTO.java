package com.example.demo.model;

import java.time.LocalDateTime;
import java.util.List;

import com.example.demo.entity.Booking;
import com.example.demo.entity.Court;
import com.example.demo.entity.User;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingDTO {

	private int id;

	private User user;
	
	private Court court;
	
	private LocalDateTime bookingDateTime;
	
	private LocalDateTime courtDateTimeBooking;
	
	private boolean deleted;
	
}
