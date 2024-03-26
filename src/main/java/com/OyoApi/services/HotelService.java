package com.OyoApi.services;

import com.OyoApi.entity.Hotel;

import java.util.List;

public interface HotelService {

    public List<Hotel> getAllHotels();

    public Hotel getHotelById(long id);

    public Hotel createHotel(Hotel hotel);

    public Hotel updateHotel(long id, Hotel hotel);

    public void deleteHotel(long id);


}
