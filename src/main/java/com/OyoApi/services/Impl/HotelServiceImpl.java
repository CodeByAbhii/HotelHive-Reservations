package com.OyoApi.services.Impl;

import com.OyoApi.entity.Hotel;
import com.OyoApi.repository.HotelRepository;
import com.OyoApi.services.HotelService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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

    @Override
    public Hotel getHotelById(long id) {
        Hotel hotel = hotelRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Hotel not found")
        );
        if (hotel!= null){
            return hotel;
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Hotel not found");
        }
    }

    @Override
    public Hotel createHotel(Hotel hotel) {
        Hotel saveHotel = hotelRepository.save(hotel);
        return saveHotel;
    }

    @Override
    public Hotel updateHotel(long id, Hotel hotel) {

        Hotel hotel1 = hotelRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Hotel not found")
        );
        hotel1.setId(hotel.getId());
        hotel.setName(hotel.getName());
        hotel.setDescription(hotel.getDescription());
        hotel.setReview(hotel.getReview());

        Hotel hotelUpdated = hotelRepository.save(hotel1);

        return hotelUpdated;
    }


    @Override
    public void deleteHotel(long id) {
        Hotel hotelNotFound = hotelRepository.findById(id).orElseThrow(
                ()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Hotel not found")
        );
        if (hotelNotFound != null){
            hotelRepository.deleteById(id);
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Hotel not found");
        }

    }
}
