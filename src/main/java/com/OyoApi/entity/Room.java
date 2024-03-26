package com.OyoApi.entity;


import jakarta.persistence.*;
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
    private String roomNumber;
    private String roomType;



    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "customer_c_id", nullable = false, unique = true)
    private Customer customer;

}
