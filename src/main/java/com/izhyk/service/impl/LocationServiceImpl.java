package com.izhyk.service.impl;

import com.izhyk.domain.Location;
import com.izhyk.exception.LocationNotFoundException;
import com.izhyk.repository.LocationRepository;
import com.izhyk.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {
    @Autowired
    LocationRepository locationRepository;


    public List<Location> findAll() {
        return locationRepository.findAll();
    }


    public Location findById(Integer id) {
                return locationRepository.findById(id)
                .orElseThrow(() -> new LocationNotFoundException(id));
    }

    @Transactional
    public Location create(Location location) {
        locationRepository.save(location);
        return location;
    }

    @Transactional
    public void update(Integer id, Location ulocation) {

        Location location = locationRepository.findById(id)
                .orElseThrow(() -> new LocationNotFoundException(id));
        //update
        location.setCity(ulocation.getCity());
        location.setCountryName(ulocation.getCountryName());
        location.setStreet(ulocation.getStreet());

        locationRepository.save(location);
    }

    @Transactional
    public void delete(Integer id) {
        Location location = locationRepository.findById(id)
                .orElseThrow(() -> new LocationNotFoundException(id));
        locationRepository.delete(location);
    }

    @Override
    public List<Location> findByCity(String city) {
        return locationRepository.findByCity(city);
    }

}
