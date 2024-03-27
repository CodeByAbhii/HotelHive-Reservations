package com.OyoApi.controller;

import com.OyoApi.entity.Booking;
import com.OyoApi.entity.Customer;
import com.OyoApi.entity.Payment;
import com.OyoApi.entity.Room;
import com.OyoApi.exception.BookingNotFoundException;
import com.OyoApi.payload.BookingDto;
import com.OyoApi.payload.BookingRequestDTO;
import com.OyoApi.payload.PaymentDto;
import com.OyoApi.services.BookingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/booking")
public class BookingController {

    private BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    // http://localhost:8080/api/booking/make?roomId=1&cId=1
    @PostMapping("/make")
    public ResponseEntity<?> makeBooking(
            @RequestParam long roomId,
            @RequestParam long cId,
            @RequestBody BookingDto bookingDtO
    ) {
        BookingDto booking = bookingService.makeBooking(roomId, cId, bookingDtO);
        return new ResponseEntity<>("Booking Successfully", HttpStatus.CREATED);
    }

    // http://localhost:8080/api/booking/confirm/{id}
    @PostMapping("/confirm/{id}")
    public ResponseEntity<?> confirmBooking(@PathVariable Long id) {
        try {
            bookingService.confirmBooking(id);
            return new ResponseEntity<>("Booking confirmed successfully", HttpStatus.OK);
        } catch (BookingNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }


    // http://localhost:8080/api/booking/cancel/{id}
    @PostMapping("/cancel/{id}")
    public ResponseEntity<?> cancelBooking(@PathVariable long id) {
        try {
            bookingService.cancelBooking(id);
            return new ResponseEntity<>("Booking cancelled successfully", HttpStatus.OK);
        } catch (BookingNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }





}
