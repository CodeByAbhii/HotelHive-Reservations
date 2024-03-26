package com.OyoApi.services;

import com.OyoApi.entity.Booking;
import com.OyoApi.entity.Customer;
import com.OyoApi.entity.Payment;
import com.OyoApi.entity.Room;
import com.OyoApi.payload.BookingDto;
import com.OyoApi.payload.PaymentDto;

import java.time.LocalDate;

public interface BookingService {

    public BookingDto makeBooking(Long roomId, Long cId, BookingDto bookingDto);

    public void confirmBooking(Long id);

    void cancelBooking(Long id);
}
