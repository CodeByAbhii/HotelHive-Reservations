package com.OyoApi.controller;


import com.OyoApi.entity.Room;
import com.OyoApi.services.RoomService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rooms")
public class RoomController {

    private RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }


    //http://localhost:8080/api/rooms
    @GetMapping
    public ResponseEntity<List<Room>>getAllRoom(){
        List<Room> allRoom = roomService.getAllRoom();
        return new ResponseEntity<>(allRoom , HttpStatus.OK);

    }
    //http://localhost:8080/api/rooms
    @PostMapping
    public ResponseEntity<Room> createRoom(@RequestBody Room room) {
        Room createdRoom = roomService.createRoom(room);
        return new ResponseEntity<>(createdRoom, HttpStatus.CREATED);
    }
    @DeleteMapping("/{roomId}")
    public ResponseEntity<String> deleteRoom(@PathVariable("roomId") Long roomId) {
        roomService.deleteRoom(roomId);
        return new ResponseEntity<>("Room with id: " + roomId + " has been deleted", HttpStatus.OK);
    }
    //http://localhost:8080/api/rooms/1
    @GetMapping("/{roomId}")
    public ResponseEntity<Room> getRoomById(@PathVariable long roomId) {
        Room room = roomService.getRoomById(roomId);
        return new ResponseEntity<>(room, HttpStatus.OK);
    }
    //http://localhost:8080/api/rooms?id=1

    //http://localhost:8080/api/rooms?id=1
    //create update api methods
    //http://localhost:8080/api/rooms/1
    @PutMapping("/{roomId}")
    public ResponseEntity<Room> updateRoom(@PathVariable("roomId") Long roomId, @RequestBody Room room) {
        Room updatedRoom = roomService.updateRoom(roomId, room);
        return new ResponseEntity<>(updatedRoom, HttpStatus.OK);
    }
}
