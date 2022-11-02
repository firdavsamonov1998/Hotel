package com.example.hotel.controller;

import com.example.hotel.entity.Room;
import com.example.hotel.service.RoomService;
import com.example.hotel.temporaryDTO.RoomDTO;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/room")

public class RoomController {
    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @PostMapping//this method adds new room
    private String addRoom(@RequestBody RoomDTO roomDTO) {
        return roomService.saveRoom(roomDTO);
    }

    @GetMapping //this method returns all the room did paging
    private Page<Room> getRoom(@RequestParam Integer page) {
        return roomService.getRooms(page);
    }

    @GetMapping("/{id}") // this method returns the room by id
    private Room getRoomById(@PathVariable Integer id) {
        return roomService.getRoomById(id);
    }

    @PutMapping("/{id}") //this method updates the room
    private String etidingRoom(@PathVariable Integer id, @RequestBody RoomDTO roomDTO) {
        return roomService.editingRoom(id, roomDTO);
    }

    @DeleteMapping("/{id}") // this method deletes the room by id
    private String deletingRoom(@PathVariable Integer id) {
        return roomService.delete(id);
    }
}
