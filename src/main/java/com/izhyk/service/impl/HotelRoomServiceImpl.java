package com.izhyk.service.impl;

import com.izhyk.domain.HotelRoom;
import com.izhyk.domain.Location;
import com.izhyk.exception.HotelRoomNotFoundException;
import com.izhyk.repository.HotelRoomRepository;
import com.izhyk.repository.LocationRepository;
import com.izhyk.service.HotelRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class HotelRoomServiceImpl implements HotelRoomService {
    @Autowired
    HotelRoomRepository hotelRoomRepository;


    public List<HotelRoom> findAll() {
        return hotelRoomRepository.findAll();
    }


    public HotelRoom findById(Integer id) {
        return hotelRoomRepository.findById(id)
                .orElseThrow(() -> new HotelRoomNotFoundException(id));
    }

    @Transactional
    public HotelRoom create(HotelRoom hotelRoom) {
        hotelRoomRepository.save(hotelRoom);
        return hotelRoom;
    }

    @Transactional
    public void update(Integer id, HotelRoom uHotelRoom) {

        HotelRoom hotelRoom = hotelRoomRepository.findById(id)
                .orElseThrow(() -> new HotelRoomNotFoundException(id));
        //update
        hotelRoom.setIsFree(uHotelRoom.getIsFree());
        hotelRoom.setPrice(uHotelRoom.getPrice());
        hotelRoom.setNumberOfPlaces(uHotelRoom.getPrice());

        hotelRoomRepository.save(hotelRoom);
    }

    @Transactional
    public void delete(Integer id) {
        HotelRoom hotelRoom = hotelRoomRepository.findById(id)
                .orElseThrow(() -> new HotelRoomNotFoundException(id));
        hotelRoomRepository.delete(hotelRoom);
    }

}
