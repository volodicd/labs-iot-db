package com.izhyk.service.impl;


import com.izhyk.dao.HotelRoomDao;
import com.izhyk.domain.HotelRoom;

import com.izhyk.service.HotelRoomService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelRoomServiceImpl implements HotelRoomService {
    @Autowired
    private HotelRoomDao hotelRoomDao;

    @Override
    public List<HotelRoom> findAll() {
        return hotelRoomDao.findAll();
    }

    @Override
    public Optional<HotelRoom> findById(Integer id) {
        return hotelRoomDao.findById(id);
    }

    @Override
    public int create(HotelRoom hotelRoom) {
        return hotelRoomDao.create(hotelRoom);
    }

    @Override
    public int update(Integer id, HotelRoom hotelRoom) {
        return hotelRoomDao.update(id, hotelRoom);
    }

    @Override
    public int delete(Integer id) {
        return hotelRoomDao.delete(id);
    }

    @Override
    public Optional<HotelRoom> findByNumberOfPlaces(Integer numberOfPlaces) {
        return hotelRoomDao.findByNumberOfPlaces(numberOfPlaces);
    }

}