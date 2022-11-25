package com.izhyk.dao;

import com.izhyk.dao.GeneralDao;
import com.izhyk.domain.Location;

import java.util.Optional;

public interface LocationDao extends GeneralDao<Location, Integer> {

    Optional<Location> findByCountry(String countryName);

}
