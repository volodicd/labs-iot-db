package com.izhyk.dao;

import com.izhyk.dao.GeneralDao;
import com.izhyk.domain.HotelRoom;

import java.util.Optional;

public interface HotelRoomDao extends GeneralDao<HotelRoom, Integer> {

    Optional<HotelRoom> findByNumberOfPlaces(Integer numberOfPlaces);
}
