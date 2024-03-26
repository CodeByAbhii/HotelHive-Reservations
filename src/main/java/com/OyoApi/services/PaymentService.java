package com.OyoApi.services;

import com.OyoApi.entity.Booking;
import com.OyoApi.entity.Payment;
import com.OyoApi.repository.BookingRepository;
import com.OyoApi.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private final BookingRepository bookingRepository;
    private final PaymentRepository paymentRepository;

    @Autowired
    public PaymentService(BookingRepository bookingRepository, PaymentRepository paymentRepository) {
        this.bookingRepository = bookingRepository;
        this.paymentRepository = paymentRepository;
    }

    public Payment makePayment(long bookingId, Payment payment) {
        // Find the booking by ID
        Booking booking = bookingRepository.findById(bookingId).orElseThrow(
                () -> new RuntimeException("Booking not found with ID: " + bookingId));

        // Set the booking for the payment
        payment.setBooking(booking);

        // Set payment as successful (assuming it's successful upon creation)
        payment.setSuccessful(true);

        // Save the payment
        Payment savedPayment = paymentRepository.save(payment);

        return savedPayment;
    }
}
