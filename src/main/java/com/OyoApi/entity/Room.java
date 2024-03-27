package com.OyoApi.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long roomId;

    @NotBlank(message = "Name cannot be blank")
    @Size(max = 255, message = "Name must not exceed 255 characters")
    private String name;

    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "City cannot be blank")
    @Size(max = 255, message = "City must not exceed 255 characters")
    private String city;

    @NotBlank(message = "State cannot be blank")
    @Size(max = 255, message = "State must not exceed 255 characters")
    private String state;

    @NotBlank(message = "Country cannot be blank")
    @Size(max = 255, message = "Country must not exceed 255 characters")
    private String country;

    @NotBlank(message = "Zip code cannot be blank")
    @Size(max = 255, message = "Zip code must not exceed 255 characters")
    private String zipCode;

    @NotBlank(message = "Phone number cannot be blank")
    @Pattern(regexp = "[0-9]+", message = "Phone number must contain only digits")
    @Size(max = 255, message = "Phone number must not exceed 255 characters")
    private String phoneNumber;

    @NotBlank(message = "Description cannot be blank")
    private String description;

    @NotBlank(message = "Review cannot be blank")
    private String review;

    @NotBlank(message = "Room number cannot be blank")
    @Size(max = 255, message = "Room number must not exceed 255 characters")
    private String roomNumber;

    @NotBlank(message = "Room type cannot be blank")
    @Size(max = 255, message = "Room type must not exceed 255 characters")
    private String roomType;

    @NotBlank(message = "Price cannot be blank")
    private String price;

    @NotBlank(message = "Status cannot be blank")
    private String status;


    @OneToOne
    @JoinColumn(name = "c_id")
    private Customer customer;

}
