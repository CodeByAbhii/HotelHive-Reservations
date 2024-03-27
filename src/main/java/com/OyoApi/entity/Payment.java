package com.OyoApi.entity;

import jakarta.persistence.*;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId;


    @NotNull
    @DecimalMin(value = "0.01", message = "Amount must be greater than 0")
    private BigDecimal amount;

    @NotNull
    private LocalDateTime paymentDate;

    @NotBlank
    private String paymentMethod;

    private boolean isSuccessful;

    @NotBlank
    @Column(name = "transaction_Id" , nullable = false ,unique = true)
    private String transactionId;

    // Additional fields related to payment details
    @NotBlank
    private String cardNumber;

    @NotBlank
    private String cardHolderName;

    @NotBlank
    @Pattern(regexp = "\\d{2}/\\d{2}", message = "Expiry date must be in MM/YY format")
    private String expiryDate;

    @NotBlank
    @Pattern(regexp = "\\d{3}", message = "CVV must be a 3-digit number")
    private String cvv;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "booking_id")
    private Booking booking;


// Getters and setters
}
