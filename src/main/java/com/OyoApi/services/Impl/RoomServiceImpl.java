package com.OyoApi.services.Impl;

import com.OyoApi.entity.Room;
import com.OyoApi.exception.EntityNotFoundException;
import com.OyoApi.repository.RoomRepository;
import com.OyoApi.services.RoomService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {

    private RoomRepository roomRepository;

    public RoomServiceImpl(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
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
    public Room createRoom(Room room) {
        Room room1 = new Room();
        room1.setRoomId(room.getRoomId());
        room1.setRoomType(room.getRoomType());
        room1.setRoomNumber(room.getRoomNumber());
        Room saveRoom = roomRepository.save(room1);
        return saveRoom;
    }
}
