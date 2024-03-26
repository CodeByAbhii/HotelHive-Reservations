package com.OyoApi.controller;


import com.OyoApi.entity.Payment;
import com.OyoApi.services.BookingService;
import com.OyoApi.services.PaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payment")
public class PaymentContoller {

    private BookingService bookingService;
    private PaymentService paymentService;




    //http://localhost:8080/api/payment?bookingId=1
    @PostMapping
    public ResponseEntity<?> makePayment(
            @RequestParam long bookingId,
            @RequestBody Payment payment
    ){


        Payment payment1 = paymentService.makePayment(bookingId ,payment); // Call the createPayment method on the instantiated object
        return new ResponseEntity<>("Payment successfully.", HttpStatus.CREATED);

    }

}
