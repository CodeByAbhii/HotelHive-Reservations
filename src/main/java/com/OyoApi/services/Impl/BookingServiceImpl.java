package com.OyoApi.services.Impl;

import com.OyoApi.entity.Booking;
import com.OyoApi.entity.Customer;
import com.OyoApi.entity.Room;

import com.OyoApi.payload.BookingDto;
import com.OyoApi.repository.BookingRepository;
import com.OyoApi.repository.CustomerRepository;
import com.OyoApi.repository.RoomRepository;
import com.OyoApi.services.BookingService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService {

    private  BookingRepository bookingRepository;

    private  CustomerRepository customerRepository;

    private  RoomRepository roomRepository;

    @Autowired
    public BookingServiceImpl(BookingRepository bookingRepository, CustomerRepository customerRepository, RoomRepository roomRepository) {
        this.bookingRepository = bookingRepository;
        this.customerRepository = customerRepository;
        this.roomRepository = roomRepository;
    }



    public BookingDto makeBooking(long roomId, long cId, BookingDto bookingDto) {
        Customer customer1 = customerRepository.findById(cId).orElseThrow(
                () -> new EntityNotFoundException("Customer not found"));

        Room room1 = roomRepository.findById(roomId).orElseThrow(
                () -> new EntityNotFoundException("Room not found"));

        // Create the new booking entity
        Booking booking = new Booking();
        booking.setId(bookingDto.getId());
        booking.setCustomerName(bookingDto.getCustomerName());
        booking.setCheckInDate(bookingDto.getCheckInDate());
        booking.setCheckOutDate(bookingDto.getCheckOutDate());
        booking.setConfirmed(false);
        booking.setRoomNumber(bookingDto.getRoom().getRoomNumber());
        booking.setRoomType(bookingDto.getRoom().getRoomType());
        booking.setEmail(bookingDto.getEmail());
        booking.setMobile(bookingDto.getCustomer().getMobile());
        booking.setPrice(bookingDto.getPrice());
        booking.setRoom(room1);
        booking.setCustomer(customer1);

        // Save the booking
        Booking saveBooking = bookingRepository.save(booking);

        BookingDto dto = new BookingDto();
        dto.setId(saveBooking.getId());
        dto.setCustomerName(saveBooking.getCustomerName());
        dto.setCheckInDate(saveBooking.getCheckInDate());
        dto.setCheckOutDate(saveBooking.getCheckOutDate());
        dto.setConfirmed(false);
        dto.setRoomNumber(saveBooking.getRoom().getRoomNumber());
        dto.setRoomType(saveBooking.getRoom().getRoomType());
        dto.setEmail(saveBooking.getEmail());
        dto.setMobile(saveBooking.getCustomer().getMobile());
        dto.setPrice(saveBooking.getPrice());
        dto.setRoom(room1);
        dto.setCustomer(customer1);

        return dto;
    }

    public void confirmBooking(Long id) {

        Booking booking = bookingRepository.getBookingById(id);
        if (booking != null) {
            booking.setConfirmed(true);
            // Save the updated booking
            bookingRepository.save(booking);
        }else{
            throw new EntityNotFoundException("Booking not found with ID: " + id);
        }
    }

    public void cancelBooking(Long id) {

        Booking booking = bookingRepository.getBookingById(id);
        if (booking != null) {
            booking.setConfirmed(false);
            // Save the updated booking
            bookingRepository.save(booking);
        }else{
            throw new EntityNotFoundException("Booking not found with ID: " + id);
        }
        bookingRepository.delete(booking);
    }
}






