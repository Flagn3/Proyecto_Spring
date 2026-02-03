package com.example.demo.model;

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

	private int facilityId;

	public CourtDTO(String name, String category, int bookingDuration, int facilityId) {
		super();
		this.name = name;
		this.category = category;
		this.bookingDuration = bookingDuration;
		this.facilityId = facilityId;
	}
	
	
	
	

//	private Facility facility;

//	private List<Booking> bookings;

}
