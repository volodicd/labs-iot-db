package com.izhyk.dao.impl;

import com.izhyk.dao.HotelDao;
import com.izhyk.domain.Hotel;
import com.izhyk.domain.HotelsBranch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("SqlResolve")
@Service
public class HotelDaoImpl implements HotelDao {
    private static final String FIND_ALL = "SELECT * FROM  hotel";
    private static final String CREATE = "INSERT hotel(hotel, hotels_branch_id) VALUES (?, ?)";
    private static final String UPDATE = "UPDATE hotel SET hotel=?, hotels_branch_id =?";
    private static final String DELETE = "DELETE FROM hotel WHERE hotel=?";
    private static final String FIND_BY_ID = "SELECT * FROM hotel WHERE hotel=?";

    private static final String FIND_BY_NAME = "SELECT * FROM hotel WHERE name=?";
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Hotel> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(Hotel.class));
    }


    @Override
    public Optional<Hotel> findById(Integer id) {
        Optional<Hotel> hotel;
        try {
            hotel = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(Hotel.class), id));
        } catch (EmptyResultDataAccessException e) {
            hotel = Optional.empty();
        }
        return hotel;
    }

    @Override
    public int create(Hotel hotel) {
        return jdbcTemplate.update(CREATE, hotel.getName(), hotel.getHotelsBranchId());
    }



    @Override
    public int update(Integer id, Hotel hotel) {
        return jdbcTemplate.update(UPDATE, hotel.getName(), hotel.getHotelsBranchId(), id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }


    @Override
    public Optional<Hotel> findByHotelName(String name) {
        Optional<Hotel> hotel;
        try {
            hotel = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_NAME,
                    BeanPropertyRowMapper.newInstance(Hotel.class), name));
        } catch (EmptyResultDataAccessException e) {
            hotel = Optional.empty();
        }
        return hotel;
    }
}





