package com.izhyk.service.impl;

import com.izhyk.domain.HotelsBranch;
import com.izhyk.domain.Location;
import com.izhyk.exception.HotelsBranchNotFoundException;
import com.izhyk.repository.HotelsBranchRepository;
import com.izhyk.repository.LocationRepository;
import com.izhyk.service.HotelsBranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class HotelsBranchServiceImpl implements HotelsBranchService {
    @Autowired
    HotelsBranchRepository hotelsBranchRepository;


    public List<HotelsBranch> findAll() {
        return hotelsBranchRepository.findAll();
    }


    public HotelsBranch findById(Integer id) {
        return hotelsBranchRepository.findById(id)
                .orElseThrow(() -> new HotelsBranchNotFoundException(id));
    }

    @Transactional
    public HotelsBranch create(HotelsBranch hotelsBranch) {
        hotelsBranchRepository.save(hotelsBranch);
        return hotelsBranch;
    }

    @Transactional
    public void update(Integer id, HotelsBranch uhotelsBranch) {

        HotelsBranch hotelsBranch = hotelsBranchRepository.findById(id)
                .orElseThrow(() -> new HotelsBranchNotFoundException(id));
        //update
        hotelsBranch.setName(uhotelsBranch.getName());
        hotelsBranch.setNumberOfHotels(uhotelsBranch.getNumberOfHotels());


        hotelsBranchRepository.save(hotelsBranch);
    }

    @Transactional
    public void delete(Integer id) {
        HotelsBranch hotelsBranch = hotelsBranchRepository.findById(id)
                .orElseThrow(() -> new HotelsBranchNotFoundException(id));
        hotelsBranchRepository.delete(hotelsBranch);
    }

}
