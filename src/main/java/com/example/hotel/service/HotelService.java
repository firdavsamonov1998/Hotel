package com.example.hotel.service;

import com.example.hotel.entity.Hotel;
import com.example.hotel.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HotelService {
    @Autowired
    private HotelRepository hotelRepository;

    public String saveHotel(Hotel hotel) {
        boolean exists = hotelRepository.existsByName(hotel.getName());
        if (exists) return "This hotel is already exist";
        hotelRepository.save(hotel);
        return "Successfully added";
    }

    public Page<Hotel> getHotels(int page) {
        Pageable pageable = PageRequest.of(page, 3);
        return hotelRepository.findAll(pageable);
    }

    public Hotel getById(Integer id) {
        Optional<Hotel> optional = hotelRepository.findById(id);
        if (optional.isEmpty()) return new Hotel();
        return optional.get();
    }


    public String editingHotel(Integer id, Hotel hotel) {
        Optional<Hotel> optional = hotelRepository.findById(id);
        if (optional.isEmpty()) return "This hotel not founded";

        Hotel editedHotel = optional.get();
        editedHotel.setName(hotel.getName());
        hotelRepository.save(editedHotel);
        return "Successfully edited";
    }

    public String deletingHotel(Integer id) {
        Optional<Hotel> optional = hotelRepository.findById(id);
        if (optional.isEmpty()) return "This hotel not founded";
        hotelRepository.deleteById(id);
        return "Successfully deleted";
    }
}
