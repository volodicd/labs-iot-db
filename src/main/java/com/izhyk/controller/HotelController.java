package com.izhyk.controller;

import com.izhyk.controller.GeneralController;
import com.izhyk.domain.Hotel;
import com.izhyk.domain.Location;

import java.util.Optional;

public interface HotelController extends GeneralController<Hotel, Integer> {
    Optional<Hotel> findByHotelName(String name);
}
