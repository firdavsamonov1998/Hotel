package com.example.hotel.controller;

import com.example.hotel.entity.Hotel;
import com.example.hotel.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController

@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    private HotelService hotelService;


    @PostMapping//this method adds new hotel
    private String addHotel(@RequestBody Hotel hotel) {
        return hotelService.saveHotel(hotel);
    }

    @GetMapping//this method returs all hotels
    private Page<Hotel> getHotels(@RequestParam int page) {
        return hotelService.getHotels(page);
    }

    @GetMapping("/{id}")//this method returns the hotel by id
    private Hotel getHotelById(@PathVariable Integer id) {
        return hotelService.getById(id);
    }

    @PutMapping("/{id}")//this method edites the hotel that existed in DB
    private String editingHotel(@PathVariable Integer id, @RequestBody Hotel hotel) {
        return hotelService.editingHotel(id, hotel);
    }

    @DeleteMapping("/{id}")//this methods deletes the hotel that existed in DB
    private String deletingHotel(@PathVariable Integer id) {
        return hotelService.deletingHotel(id);
    }
}
