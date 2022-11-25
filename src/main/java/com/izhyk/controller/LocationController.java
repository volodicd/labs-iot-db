package com.izhyk.controller;

import com.izhyk.domain.Location;

import java.util.Optional;

public interface LocationController extends GeneralController<Location, Integer> {
    Optional<Location> findByCountry(String countryName);
}
