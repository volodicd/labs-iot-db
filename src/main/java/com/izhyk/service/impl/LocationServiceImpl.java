package com.izhyk.service.impl;

import com.izhyk.dao.LocationDao;
import com.izhyk.dao.UserDao;
import com.izhyk.domain.Location;
import com.izhyk.domain.User;
import com.izhyk.service.LocationService;
import com.izhyk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationServiceImpl implements LocationService {
    @Autowired
    private LocationDao locationDao;

    @Override
    public List<Location> findAll() {
        return locationDao.findAll();
    }

    @Override
    public Optional<Location> findById(Integer id) {
        return locationDao.findById(id);
    }

    @Override
    public int create(Location location) {
        return locationDao.create(location);
    }

    @Override
    public int update(Integer id, Location location) {
        return locationDao.update(id, location);
    }

    @Override
    public int delete(Integer id) {
        return locationDao.delete(id);
    }

    @Override
    public Optional<Location> findByCountry(String countryName) {
        return locationDao.findByCountry(countryName);
    }

}