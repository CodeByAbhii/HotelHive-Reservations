package com.OyoApi.repository;

import com.OyoApi.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking , Long> {
    Booking getBookingById(long bookingId);
}
