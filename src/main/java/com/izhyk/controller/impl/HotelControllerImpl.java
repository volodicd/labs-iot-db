package com.izhyk.controller.impl;

import com.izhyk.controller.HotelController;
import com.izhyk.dao.HotelDao;
import com.izhyk.domain.Hotel;
import com.izhyk.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelControllerImpl implements HotelController {
    @Autowired
    private HotelService hotelService;

    @Override
    public List<Hotel> findAll() {
        return hotelService.findAll();
    }

    @Override
    public Optional<Hotel> findById(Integer id) {
        return hotelService.findById(id);
    }

    @Override
    public int create(Hotel hotel) {
        return hotelService.create(hotel);
    }

    @Override
    public int update(Integer id, Hotel hotel) {
        return hotelService.update(id, hotel);
    }

    @Override
    public int delete(Integer id) {
        return hotelService.delete(id);
    }

    @Override
    public Optional<Hotel> findByHotelName(String name) {
        return hotelService.findByHotelName(name);
    }
}
