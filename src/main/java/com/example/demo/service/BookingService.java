package com.example.demo.service;

import java.util.List;

import com.example.demo.model.BookingDTO;

public interface BookingService {

	List<BookingDTO> listAllBookings();
	
	BookingDTO getBookingById(int id);
	
	BookingDTO getBookingByUserId(int id);
	
	int addBooking(BookingDTO bookingDTO);
	
	int deleteBooking(int id);
	
}
