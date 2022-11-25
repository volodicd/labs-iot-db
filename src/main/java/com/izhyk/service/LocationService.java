package com.izhyk.service;

import com.izhyk.domain.Location;


import java.util.List;

public interface LocationService extends GeneralService<Location, Integer> {
    List<Location> findByCity(String city);




}
