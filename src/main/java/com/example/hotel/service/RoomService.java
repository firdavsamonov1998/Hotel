package com.example.hotel.service;

import com.example.hotel.entity.Hotel;
import com.example.hotel.entity.Room;
import com.example.hotel.repository.HotelRepository;
import com.example.hotel.repository.RoomRepository;
import com.example.hotel.temporaryDTO.RoomDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    public Page<Room> getRooms(Integer page) {
        Pageable pageable = PageRequest.of(page, 10);
        return roomRepository.findAll(pageable);
    }

    public Room getRoomById(Integer id) {
        Optional<Room> optional = roomRepository.findById(id);
        if (optional.isEmpty()) return new Room();
        return optional.get();
    }

    public String editingRoom(Integer id, RoomDTO roomDTO) {
        Optional<Hotel> optional = hotelRepository.findById(roomDTO.getHotelId());
        if (optional.isEmpty()) return "The hotel not founded";
        Hotel hotel = optional.get();
        List<Hotel> hotelList = new LinkedList<>();
        hotelList.add(hotel);

        Optional<Room> optionalRoom = roomRepository.findById(id);
        if (optionalRoom.isEmpty()) return "The room not founded";
        Room room = optionalRoom.get();
        room.setNumber(roomDTO.getNumber());
        room.setSize(roomDTO.getSize());
        room.setHotel(hotelList);
        roomRepository.save(room);
        return "Successfully updated";
    }

    public String delete(Integer id) {
        Optional<Room> optional = roomRepository.findById(id);
        if (optional.isEmpty()) return "Not founded";
        roomRepository.deleteById(id);
        return "Successfully deleted";
    }
}
