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

    @GetMapping
    private Page<Room> getRoom(@RequestParam Integer page) {
        return null;
    }
}
