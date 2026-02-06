package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Booking;
import com.example.demo.model.BookingDTO;
import com.example.demo.repository.BookingRepository;
import com.example.demo.repository.CourtRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.BookingService;

@Service("bookingService")
public class BookingServiceImpl implements BookingService {

	@Autowired
	@Qualifier("bookingRepository")
	private BookingRepository bookingRepository;

	@Autowired
	@Qualifier("courtRepository")
	private CourtRepository courtRepository;

	@Autowired
	@Qualifier("userRepository")
	private UserRepository userRepository;

	@Override
	public List<BookingDTO> getAllBookings() {
		List<Booking> bookings = bookingRepository.findAll();
		List<BookingDTO> bookingDTOs = new ArrayList<>();
		for (Booking b : bookings) {
			bookingDTOs.add(transform(b));
		}
		return bookingDTOs;
	}

	@Override
	public List<BookingDTO> getAllBookingsByFacility(long id) {
		List<BookingDTO> bookings = new ArrayList<>();
		for (Booking b : bookingRepository.findAll()) {
			if (b.getCourt().getFacility().getId() == id) {
				bookings.add(transform(b));
			}
		}
		return bookings;
	}

	@Override
	public List<BookingDTO> getAllBookingsByCourt(long id) {
		List<Booking> bookings = bookingRepository.findByCourtIdAndDeletedFalse(id);
		List<BookingDTO> bookingDTOs = new ArrayList<>();
		for (Booking b : bookings) {
			bookingDTOs.add(transform(b));
		}
		return bookingDTOs;
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
		for (Booking b : bookingRepository.findAll()) {
			if (b.getUser().getId() == id) {
				bookingsByUser.add(transform(b));
			}
		}

		return bookingsByUser;
	}

	@Override
	public void addBooking(BookingDTO bookingDTO) {

		Booking booking = new Booking();
		booking.setCourtDateTimeBooking(bookingDTO.getCourtDateTimeBooking());
		booking.setBookingDateTime(bookingDTO.getBookingDateTime());
		booking.setDeleted(false);

		booking.setCourt(courtRepository.findById(bookingDTO.getCourtId()).orElse(null));
		booking.setUser(userRepository.findById(bookingDTO.getUserId()).orElse(null));

		bookingRepository.save(booking);

	}

	@Override
	public void deleteBooking(long id) {

		Booking booking = bookingRepository.findById(id).orElseThrow(() -> new RuntimeException("Booking not found"));
		booking.setDeleted(true);
		bookingRepository.save(booking);

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
