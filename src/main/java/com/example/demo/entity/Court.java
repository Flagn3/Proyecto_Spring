package com.example.demo.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Court {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String name;

	private String category;

	private int bookingDuration;

	private boolean activated;
	private boolean deleted;

	@ManyToOne
	@JoinColumn(name = "facility_id")
	@JsonIgnore
	private Facility facility;

	@OneToMany(mappedBy = "court", cascade = CascadeType.ALL, orphanRemoval = false)
	@JsonIgnore
	private List<Booking> bookings;

}
