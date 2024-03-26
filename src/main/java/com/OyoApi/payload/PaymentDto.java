package com.OyoApi.payload;

import com.OyoApi.entity.Booking;
import com.OyoApi.entity.Payment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDto {
    private Payment payment;
    private Booking booking;
    private String email;
    private String message;
}
