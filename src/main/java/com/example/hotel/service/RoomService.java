package com.example.hotel.service;

import com.example.hotel.entity.Hotel;
import com.example.hotel.entity.Room;
import com.example.hotel.repository.HotelRepository;
import com.example.hotel.repository.RoomRepository;
import com.example.hotel.temporaryDTO.RoomDTO;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class RoomService {

    private final RoomRepository roomRepository;

    private final HotelRepository hotelRepository;

    public RoomService(RoomRepository roomRepository, HotelRepository hotelRepository) {
        this.roomRepository = roomRepository;
        this.hotelRepository = hotelRepository;
    }


    public String saveRoom(RoomDTO roomDTO) {
        Optional<Hotel> optional = hotelRepository.findById(roomDTO.getHotelId());
        if (optional.isEmpty()) return "Not founded";
        Hotel hotel = optional.get();
        List<Hotel> hotelList = new LinkedList<>();
        hotelList.add(hotel);
        Room room = new Room();
        room.setNumber(roomDTO.getNumber());
        room.setSize(roomDTO.getSize());
        room.setHotel(hotelList);
        roomRepository.save(room);
        return "Successfully added";
    }
}
