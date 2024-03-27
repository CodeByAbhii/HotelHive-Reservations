package com.OyoApi.services.Impl;

import com.OyoApi.entity.Customer;
import com.OyoApi.entity.Room;
import com.OyoApi.exception.EntityNotFoundException;
import com.OyoApi.repository.CustomerRepository;
import com.OyoApi.repository.RoomRepository;
import com.OyoApi.services.RoomService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {

    private RoomRepository roomRepository;

    private CustomerRepository customerRepository;

    public RoomServiceImpl(RoomRepository roomRepository, CustomerRepository customerRepository) {
        this.roomRepository = roomRepository;
        this.customerRepository = customerRepository;
    }



    @Override
    public List<Room> getAllRoom() {
        List<Room>getAllRoom = roomRepository.findAll();
        return getAllRoom;
    }

    @Override
    public void deleteRoom(Long roomId) {
        roomRepository.deleteById(roomId);
    }

    @Override
    public Room updateRoom(Long roomId, Room room) {
        Room room1 = roomRepository.findById(roomId).get();
        room1.setRoomId(room.getRoomId());
        room1.setRoomType(room.getRoomType());
        room1.setRoomNumber(room.getRoomNumber());
        Room saveRoom = roomRepository.save(room1);
        return saveRoom;
    }

    @Override
    public Room getRoomById(Long id) {
        Room roomNotFound = roomRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Room not found"));
        if (roomNotFound!=null){
            Room room = roomRepository.findById(id).get();
            return room;
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Room not found");
        }

    }

    @Override
    public Room createRoom(Long cId, Room room) {
        Customer customer = customerRepository.findById(cId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found with ID: " + cId));

        room.setCustomer(customer);
        return roomRepository.save(room);
    }


    }

