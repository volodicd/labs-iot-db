package com.izhyk.controller;

import com.izhyk.controller.GeneralController;
import com.izhyk.domain.HotelRoom;
import com.izhyk.domain.Location;

import java.util.Optional;

public interface HotelRoomController extends GeneralController<HotelRoom, Integer> {
    Optional<HotelRoom> findByNumberOfPlaces(Integer numberOfPlaces);
}
