package com.OyoApi.services.Impl;

import com.OyoApi.entity.Hotel;
import com.OyoApi.repository.HotelRepository;
import com.OyoApi.services.HotelService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class HotelServiceImpl implements HotelService {


    private HotelRepository hotelRepository;

    public HotelServiceImpl(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public List<Hotel> getAllHotels() {
        List<Hotel> hotels = hotelRepository.findAll();
        return hotels;
    }
}
