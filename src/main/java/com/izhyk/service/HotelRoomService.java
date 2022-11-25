package com.izhyk.service;

import com.izhyk.domain.HotelRoom;

import java.util.Optional;

public interface HotelRoomService extends GeneralService<HotelRoom, Integer>{
    Optional<HotelRoom> findByNumberOfPlaces(Integer numberOfPlaces);
}
