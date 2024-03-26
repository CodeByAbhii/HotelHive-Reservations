package com.OyoApi.payload;

import com.OyoApi.entity.Customer;
import com.OyoApi.entity.Room;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingRequestDTO {

    private Room room;
    private Customer customer;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
}
