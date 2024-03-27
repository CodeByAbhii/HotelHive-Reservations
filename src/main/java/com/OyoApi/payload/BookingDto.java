package com.OyoApi.payload;

import com.OyoApi.entity.Booking;
import com.OyoApi.entity.Customer;
import com.OyoApi.entity.Payment;
import com.OyoApi.entity.Room;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingDto {

    private long id;
    private String customerName;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private boolean isConfirmed;
    private String roomNumber;
    private String roomType;
    private String email;
    private long mobile;
    private double price;
    private Room room;
    private Customer customer;

}
