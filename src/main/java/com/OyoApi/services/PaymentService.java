package com.OyoApi.services;

import com.OyoApi.entity.Booking;
import com.OyoApi.entity.Payment;
import com.OyoApi.repository.BookingRepository;
import com.OyoApi.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

    private final BookingRepository bookingRepository;
    private final PaymentRepository paymentRepository;

    @Autowired
    public PaymentService(BookingRepository bookingRepository, PaymentRepository paymentRepository) {
        this.bookingRepository = bookingRepository;
        this.paymentRepository = paymentRepository;
    }

    public Payment makePayment(long id, Payment payment) {
        // Find the booking by ID
        Payment getByBookingId = paymentRepository.findByBookingId(id);
        // Set the booking for the payment
       if (getByBookingId == null) {
           throw new RuntimeException("Booking not found with ID: " + id);
       }else {
           payment.setBooking(getByBookingId.getBooking());
           // Set payment as successful (assuming it's successful upon creation)
           payment.setSuccessful(true);
       }

       // Save the payment
        Payment savedPayment = paymentRepository.save(payment);
        return savedPayment;
    }

    public Payment findByBookingId(long id) {
        // Find the booking by ID
        Booking getByBookingId = bookingRepository.getBookingById(id);
        if (getByBookingId!= null) {
            // Set the booking for the payment
            getByBookingId.setConfirmed(true);
            // Save the updated booking
            bookingRepository.save(getByBookingId);
        }else {
            throw new RuntimeException("Booking not found with ID: " + id);
        }
        return null;
    }

    public void cancelBooking(long id) {
        // Find the booking by ID
        Booking getByBookingId = bookingRepository.getBookingById(id);
        if (getByBookingId!= null) {
            // Set the booking for the payment
            getByBookingId.setConfirmed(false);
            // Save the updated booking
            bookingRepository.save(getByBookingId);
        }else {
            throw new RuntimeException("Booking not found with ID: " + id);
        }
        bookingRepository.delete(getByBookingId);
    }

    public Payment updatePayment(long id, Payment payment) {
        // Find the booking by ID
        Payment getByBookingId = paymentRepository.findByBookingId(id);
        // Set the booking for the payment
       if (getByBookingId == null) {
           throw new RuntimeException("Booking not found with ID: " + id);
       }else {
           payment.setBooking(getByBookingId.getBooking());
           // Set payment as successful (assuming it's successful upon creation)
           payment.setSuccessful(true);
       }
       // Save the payment
        Payment savePayment = paymentRepository.save(payment);
        return savePayment;
    }

    public List<Payment> getAllPayments() {
        List<Payment> Payment = paymentRepository.findAll();
        return Payment;
    }
}
