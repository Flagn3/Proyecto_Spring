package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.example.demo.entity.Booking;
import com.example.demo.model.BookingDTO;
import com.example.demo.repository.BookingRepository;
import com.example.demo.service.BookingService;

public class BookingServiceImpl implements BookingService{
	
	@Autowired
	@Qualifier("bookingRepository")
	private BookingRepository bookingRepository;

	@Override
	public List<BookingDTO> listAllBookingsByFacility(long id) {
		List<BookingDTO> bookings = new ArrayList<>();
		for(Booking b : bookingRepository.findAll()) {
			if(b.getCourt().getFacility().getId() == id) {
				bookings.add(transform(b));
			}
		}
		return bookings;
	}

	@Override
	public BookingDTO getBookingById(long id) {
		BookingDTO bookingDTO = transform(
				bookingRepository.findById(id).orElseThrow(() -> new RuntimeException("Booking not found")));
		
		return bookingDTO;
	}

	@Override
	public List<BookingDTO> getBookingByUser(long id) {
		
		List<BookingDTO> bookingsByUser = new ArrayList<>();
		for(Booking b : bookingRepository.findAll()) {
			if(b.getUser().getId() == id) {
				bookingsByUser.add(transform(b));
			}
		}
		
		return bookingsByUser;
	}

	@Override
	public int addBooking(BookingDTO bookingDTO) {
		
		bookingRepository.save(transform(bookingDTO));
		
		return bookingDTO.getId();
	}

	@Override
	public long deleteBooking(long id) {
		
		Booking booking = bookingRepository.findById(id).orElseThrow(() -> new RuntimeException("Booking not found"));
		booking.setDeleted(true);
		bookingRepository.save(booking);
		return booking.getId();
	}
	
	// Transform entity into model 
	private BookingDTO transform(Booking booking) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(booking, BookingDTO.class);
	}

	// Transform model into entity
	private Booking transform(BookingDTO bookingDTO) {

		ModelMapper modelMapper = new ModelMapper();
		Booking booking = modelMapper.map(bookingDTO, Booking.class);

		return booking;

	}


	
	
}
