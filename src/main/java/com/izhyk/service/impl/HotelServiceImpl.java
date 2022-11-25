package com.izhyk.service.impl;

import com.izhyk.dao.HotelDao;
import com.izhyk.dao.LocationDao;
import com.izhyk.domain.Hotel;
import com.izhyk.domain.Location;
import com.izhyk.service.HotelService;
import com.izhyk.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelServiceImpl implements HotelService {
    @Autowired
    private HotelDao hotelDao;

    @Override
    public List<Hotel> findAll() {
        return hotelDao.findAll();
    }

    @Override
    public Optional<Hotel> findById(Integer id) {
        return hotelDao.findById(id);
    }

    @Override
    public int create(Hotel hotel) {
        return hotelDao.create(hotel);
    }

    @Override
    public int update(Integer id, Hotel hotel) {
        return hotelDao.update(id, hotel);
    }

    @Override
    public int delete(Integer id) {
        return hotelDao.delete(id);
    }

    @Override
    public Optional<Hotel> findByHotelName(String name) {
        return hotelDao.findByHotelName(name);
    }

}