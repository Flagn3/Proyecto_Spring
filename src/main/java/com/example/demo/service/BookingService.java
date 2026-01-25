package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Booking;

public interface BookingService {

	List<Booking> listAllBookings();
	
	Booking getBookingById(int id);
	
	Booking getBookingByUserId(int id);
	
	int addBooking(Booking booking);
	
	int deleteBooking(int id);
	
	
}
