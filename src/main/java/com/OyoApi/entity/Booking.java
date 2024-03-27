package com.OyoApi.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Customer name cannot be blank")
    private String customerName;

    @NotNull(message = "Check-in date cannot be null")
    @PastOrPresent(message = "Check-in date must be in the past or present")
    private LocalDate checkInDate;

    @NotNull(message = "Check-out date cannot be null")
    @Future(message = "Check-out date must be in the future")
    private LocalDate checkOutDate;

    private boolean isConfirmed;

    @NotBlank(message = "Room number cannot be blank")
    private String roomNumber;

    @NotBlank(message = "Room type cannot be blank")
    private String roomType;

    @Email(message = "Invalid email format")
    private String email;

    @Positive(message = "Mobile number must be positive")
    private long mobile;

    @Positive(message = "Price must be positive")
    private double price;

    @OneToOne(cascade = CascadeType.ALL, optional = false, orphanRemoval = true)
    @JoinColumn(name = "room_id", nullable = false)
    private Room room;


    @OneToOne(cascade = CascadeType.ALL, optional = false, orphanRemoval = true)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @OneToOne(mappedBy = "booking", cascade = CascadeType.ALL, optional = false, orphanRemoval = true)
    private Payment payment;



// other fields, getters, and setters







}
