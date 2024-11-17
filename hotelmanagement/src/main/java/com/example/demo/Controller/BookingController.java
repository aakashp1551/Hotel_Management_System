package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Repository.BookingRepository;
import com.example.demo.entity.Booking;

@RestController
	@RequestMapping("/bookings")
	public class BookingController {

	    @Autowired
	    private BookingRepository bookingRepository;

	    @GetMapping
	    public List<Booking> getAllBookings() {
	        return bookingRepository.findAll();
	    }

	    @PostMapping
	    public Booking createBooking(@RequestBody Booking booking) {
	        return bookingRepository.save(booking);
	    }

	    @GetMapping("/{id}")
	    public Booking getBookingById(@PathVariable Long id) {
	        return bookingRepository.findById(id).orElseThrow();
	    }

	    @PutMapping("/{id}")
	    public Booking updateBooking(@PathVariable Long id, @RequestBody Booking booking) {
	        booking.setId(id);
	        return bookingRepository.save(booking);
	    }

	    @DeleteMapping("/{id}")
	    public void deleteBooking(@PathVariable Long id) {
	        bookingRepository.deleteById(id);
	    }
	}

