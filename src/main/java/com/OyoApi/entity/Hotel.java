package com.OyoApi.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Name cannot be blank")
    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
    private String name;

    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "City cannot be blank")
    private String city;

    @NotBlank(message = "State cannot be blank")
    private String state;

    @NotBlank(message = "Country cannot be blank")
    private String country;

    @NotBlank(message = "Zip code cannot be blank")
    @Pattern(regexp = "\\d{5}", message = "Invalid zip code format")
    private String zipCode;

    @NotBlank(message = "Phone number cannot be blank")
    @Pattern(regexp = "\\d{10,15}", message = "Invalid phone number format")
    private String phoneNumber;

    @NotBlank(message = "Description cannot be blank")
    private String description;

    // Optionally, you can validate the length of the review
    @Size(max = 255, message = "Review must be less than or equal to 255 characters")
    private String review;

}
