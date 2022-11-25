package com.izhyk.service;

import com.izhyk.domain.Hotel;

import java.util.Optional;

public interface HotelService extends GeneralService<Hotel, Integer>{
    Optional<Hotel> findByHotelName(String name);
}
