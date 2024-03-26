package com.OyoApi.controller;


import com.OyoApi.entity.Hotel;
import com.OyoApi.services.HotelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/hotel")
public class HotelController {

    private HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }


    //http://localhost:8080/api/hotel
    @GetMapping
    public ResponseEntity<List<Hotel>>getAllHotel(){
        List<Hotel> hotels = hotelService.getAllHotels();
        return new ResponseEntity<>(hotels , HttpStatus.OK);
    }
}
