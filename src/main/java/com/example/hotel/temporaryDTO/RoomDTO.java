package com.example.hotel.temporaryDTO;

import com.example.hotel.entity.Hotel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomDTO {
    private Integer number;
    private Double size;
    private Integer HotelId;
}
