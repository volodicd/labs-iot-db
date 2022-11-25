package com.izhyk.dao.impl;


import com.izhyk.dao.LocationDao;

import com.izhyk.domain.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("SqlResolve")
@Service
public class LocationDaoImpl implements LocationDao {
    private static final String FIND_ALL = "SELECT * FROM location";
    private static final String CREATE = "INSERT location(city, street, country_name) VALUES (?, ?, ?)";
    private static final String UPDATE = "UPDATE location SET city=?, street=?, country_name=? WHERE id=?";
    private static final String DELETE = "DELETE FROM location WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM location WHERE id=?";
    private static final String FIND_BY_COUNTRY = "SELECT * FROM location WHERE country_name=?";


    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Location> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(Location.class));
    }

    @Override
    public Optional<Location> findById(Integer id) {
        Optional<Location> location;
        try {
            location = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(Location.class), id));
        } catch (EmptyResultDataAccessException e) {
            location = Optional.empty();
        }
        return location;
    }

    @Override
    public int create(Location location) {
        return jdbcTemplate.update(CREATE, location.getCity(), location.getStreet(), location.getCountryName());
    }

    @Override
    public int update(Integer id, Location location) {
        return jdbcTemplate.update(UPDATE, location.getCity(), location.getStreet(), location.getCountryName(), id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }


    @Override
    public Optional<Location> findByCountry(String countryName) {
        Optional<Location> location;
        try {
            location = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_COUNTRY,
                    BeanPropertyRowMapper.newInstance(Location.class), countryName));
        } catch (EmptyResultDataAccessException e) {
            location = Optional.empty();
        }
        return location;
    }
}
