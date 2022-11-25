package com.izhyk.dao;

import com.izhyk.domain.Hotel;

import java.util.Optional;

public interface HotelDao extends GeneralDao<Hotel, Integer>{
    Optional<Hotel> findByHotelName(String name);

}
