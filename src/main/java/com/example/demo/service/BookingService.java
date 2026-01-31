package com.example.demo.service;

import java.util.List;

import com.example.demo.model.BookingDTO;

public interface BookingService {

	List<BookingDTO> listAllBookingsByFacility(long id);
	
	BookingDTO getBookingById(long id);
	
	List<BookingDTO> getBookingByUser(long id);
	
	int addBooking(BookingDTO bookingDTO);
	
	long deleteBooking(long id);
	
}
