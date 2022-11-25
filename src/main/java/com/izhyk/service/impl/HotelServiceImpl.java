package com.izhyk.service.impl;

import com.izhyk.domain.Hotel;
import com.izhyk.domain.Location;
import com.izhyk.exception.HotelNotFoundException;
import com.izhyk.repository.HotelRepository;
import com.izhyk.repository.LocationRepository;
import com.izhyk.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class HotelServiceImpl implements HotelService {
    @Autowired
    HotelRepository hotelRepository;


    public List<Hotel> findAll() {
        return hotelRepository.findAll();
    }

    public Hotel findById(Integer id) {
        return hotelRepository.findById(id)
                .orElseThrow(() -> new HotelNotFoundException(id));
    }

    @Transactional
    public Hotel create(Hotel hotel) {
        hotelRepository.save(hotel);
        return hotel;
    }

    @Transactional
    public void update(Integer id, Hotel uHotel) {

        Hotel hotel = hotelRepository.findById(id)
                .orElseThrow(() -> new HotelNotFoundException(id));
        //update
        hotel.setName(uHotel.getName());
        hotel.setNumberOfRooms(uHotel.getNumberOfRooms());

        hotelRepository.save(hotel);
    }

    @Transactional
    public void delete(Integer id) {
        Hotel hotel = hotelRepository.findById(id)
                .orElseThrow(() -> new HotelNotFoundException(id));
        hotelRepository.delete(hotel);
    }







}
