package com.OyoApi.controller;


import com.OyoApi.entity.Payment;
import com.OyoApi.services.BookingService;
import com.OyoApi.services.PaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payment")
public class PaymentContoller {

    private BookingService bookingService;
    private PaymentService paymentService;


    //http://localhost:8080/api/payment?Id=1
    @PostMapping
    public ResponseEntity<?> makePayment(
            @RequestParam long id,
            @RequestBody Payment payment
    ) {
        Payment payment1 = paymentService.makePayment(id, payment);
        return new ResponseEntity<>("Payment Successfully", HttpStatus.OK);
    }
    //http://localhost:8080/api/payment/1
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePayment(@PathVariable long id) {
        paymentService.cancelBooking(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    //http://localhost:8080/api/payment/1
    @GetMapping("/{id}")
    public ResponseEntity<Payment> getPaymentById(@PathVariable long id) {
        Payment payment = paymentService.findByBookingId(id);
        return new ResponseEntity<>(payment, HttpStatus.OK);
    }
    //http://localhost:8080/api/payment?Id=1
    @PutMapping("/{id}")
    public ResponseEntity<?> updatePayment(
            @PathVariable long id,
            @RequestBody Payment payment
    ) {
        Payment payment1 = paymentService.updatePayment(id, payment);
        return new ResponseEntity<>("Payment Successfully", HttpStatus.OK);
    }


    //http://localhost:8080/api/payment
    @GetMapping
    public ResponseEntity<?> getAllPayments() {

        List<Payment> payment = paymentService.getAllPayments();
        return new ResponseEntity<>(payment, HttpStatus.OK);
    }


}


