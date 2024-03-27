package com.OyoApi.services;

import com.OyoApi.entity.Room;

import java.util.List;

public interface RoomService {

    public List<Room> getAllRoom();

    void deleteRoom(Long roomId);

    Room updateRoom(Long roomId, Room room);

    Room getRoomById(Long id);

    Room createRoom(Long cId ,Room room);
}
