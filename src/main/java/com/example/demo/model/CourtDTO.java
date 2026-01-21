package com.example.demo.model;

import java.util.List;

import com.example.demo.entity.Booking;
import com.example.demo.entity.Facility;

import jakarta.persistence.CascadeType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourtDTO {

	private int id;

	private String name;

	private String category;

	private int bookingDuration;

	private boolean activated;
	
	private boolean deleted;

	private Facility facility;

	private List<Booking> bookings;
	
}
