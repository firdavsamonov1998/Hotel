package com.example.hotel.controller;

import com.example.hotel.service.RoomService;
import com.example.hotel.temporaryDTO.RoomDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
