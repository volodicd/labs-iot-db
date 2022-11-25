package com.izhyk.service;

import com.izhyk.domain.Location;

import java.util.Optional;

public interface LocationService extends GeneralService<Location, Integer>{


    Optional<Location> findByCountry(String countryName);
}
