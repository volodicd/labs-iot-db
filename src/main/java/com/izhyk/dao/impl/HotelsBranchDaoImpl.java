package com.izhyk.dao.impl;

import com.izhyk.dao.HotelsBranchDao;
import com.izhyk.domain.HotelsBranch;
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
public class HotelsBranchDaoImpl  implements HotelsBranchDao {

    private static final String FIND_ALL = "SELECT * FROM hotels_branch";
    private static final String CREATE = "INSERT hotels_branch( number_of_hotels, name, location_id) VALUES (?, ?)";
    private static final String UPDATE = "UPDATE hotels_branch SET number_of_hotels=?, name=?, location_id=? WHERE id=?";
    private static final String DELETE = "DELETE FROM hotels_branch WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM hotels_branch WHERE id=?";
    private static final String FIND_BY_NAME = "SELECT * FROM hotels_branch WHERE name=?";


    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<HotelsBranch> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(HotelsBranch.class));
    }

    @Override
    public Optional<HotelsBranch> findById(Integer id) {
        Optional<HotelsBranch> hotelsBranch;
        try {
            hotelsBranch = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(HotelsBranch.class), id));
        } catch (EmptyResultDataAccessException e) {
            hotelsBranch = Optional.empty();
        }
        return hotelsBranch;
    }

    @Override
    public int create(HotelsBranch hotelsBranch) {
        return jdbcTemplate.update(CREATE, hotelsBranch.getNumberOfHotels(),hotelsBranch.getName(), hotelsBranch.getLocationId());
    }

    @Override
    public int update(Integer id, HotelsBranch hotelsBranch) {
        return jdbcTemplate.update(UPDATE, hotelsBranch.getNumberOfHotels(),hotelsBranch.getName(), hotelsBranch.getLocationId(), id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }


    @Override
    public Optional<HotelsBranch> findByBranchName(String branchName) {
        Optional<HotelsBranch> hotelsBranch;
        try {
            hotelsBranch = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_NAME,
                    BeanPropertyRowMapper.newInstance(HotelsBranch.class), branchName));
        } catch (EmptyResultDataAccessException e) {
            hotelsBranch = Optional.empty();
        }
        return hotelsBranch;
    }
}
