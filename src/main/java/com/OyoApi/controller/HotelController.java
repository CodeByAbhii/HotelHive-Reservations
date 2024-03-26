package com.OyoApi.controller;


import com.OyoApi.entity.Hotel;
import com.OyoApi.services.HotelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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


    //http://localhost:8080/api/hotel
    @PostMapping
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
        Hotel newHotel = hotelService.createHotel(hotel);
        return new ResponseEntity<>(newHotel , HttpStatus.CREATED);
    }


    //http://localhost:8080/api/hotel/1
    @GetMapping("/{id}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable long id){
        Hotel hotel = hotelService.getHotelById(id);
        return new ResponseEntity<>(hotel , HttpStatus.OK);
    }


    //http://localhost:8080/api/hotel?id=1
    @PutMapping
    public ResponseEntity<Hotel> updateHotel(@RequestParam long id , @RequestBody Hotel hotel){
        Hotel updatedHotel = hotelService.updateHotel(id, hotel);
        return new ResponseEntity<>(updatedHotel , HttpStatus.OK);
    }


    //http://localhost:8080/api/hotel/1
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteHotel(@PathVariable long id){
        hotelService.deleteHotel(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
