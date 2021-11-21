package com.hcl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.model.Booking;
import com.hcl.repos.BookingRepository;

@Service
public class BookingService {
	@Autowired
	BookingRepository bookingRepository;

	public List<Booking> findByInstructor(Integer id) {
		return bookingRepository.findByInstructor(id);
	}

//	public Booking saveBooking(Booking b) {
//		return bookingRepository.save(b);
//	}

	public void saveBooking(Booking b) {
		bookingRepository.saveBooking(b.getIid(), b.getSid(), b.getStart(), b.getEnd());
	}
}
