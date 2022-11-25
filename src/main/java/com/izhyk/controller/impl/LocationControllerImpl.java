package com.izhyk.controller.impl;

import com.izhyk.controller.LocationController;
import com.izhyk.dao.LocationDao;
import com.izhyk.domain.Location;
import com.izhyk.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class LocationControllerImpl implements LocationController {
    @Autowired
    private LocationService locationService;

    @Override
    public List<Location> findAll() {
        return locationService.findAll();
    }

    @Override
    public Optional<Location> findById(Integer id) {
        return locationService.findById(id);
    }

    @Override
    public int create(Location location) {
        return locationService.create(location);
    }

    @Override
    public int update(Integer id, Location location) {
        return locationService.update(id, location);
    }

    @Override
    public int delete(Integer id) {
        return locationService.delete(id);
    }

    @Override
    public Optional<Location> findByCountry(String countryName) {
        return locationService.findByCountry(countryName);
    }

}
