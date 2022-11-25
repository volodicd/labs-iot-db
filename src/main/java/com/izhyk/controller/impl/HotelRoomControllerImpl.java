package com.izhyk.controller.impl;

import com.izhyk.controller.HotelRoomController;
import com.izhyk.domain.Hotel;
import com.izhyk.domain.HotelRoom;
import com.izhyk.service.HotelRoomService;
import com.izhyk.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class HotelRoomControllerImpl implements HotelRoomController{
    @Autowired
    private HotelRoomService hotelRoomService;

    @Override
    public List<HotelRoom> findAll() {
        return hotelRoomService.findAll();
    }

    @Override
    public Optional<HotelRoom> findById(Integer id) {
        return hotelRoomService.findById(id);
    }

    @Override
    public int create(HotelRoom hotelRoom) {
        return hotelRoomService.create(hotelRoom);
    }

    @Override
    public int update(Integer id, HotelRoom hotelRoom) {
        return hotelRoomService.update(id, hotelRoom);
    }

    @Override
    public int delete(Integer id) {
        return hotelRoomService.delete(id);
    }

    @Override
    public Optional<HotelRoom> findByNumberOfPlaces(Integer numberOfPlaces) {
        return hotelRoomService.findByNumberOfPlaces(numberOfPlaces);
    }
}
