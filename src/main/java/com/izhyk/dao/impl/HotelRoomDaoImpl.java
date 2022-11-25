package com.izhyk.dao.impl;


import com.izhyk.dao.HotelRoomDao;
import com.izhyk.domain.HotelRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("SqlResolve")
@Service
public class HotelRoomDaoImpl implements HotelRoomDao {
    private static final String FIND_ALL = "SELECT * FROM hotel_room";
    private static final String CREATE = "INSERT hotel_room(number_of_places, is_free, price, hotel_id) VALUES (?, ?, ?,?)";
    private static final String UPDATE = "UPDATE hotel_room SET number_of_places=?, is_free=?, price=?, hotel_id=? WHERE id=?";
    private static final String DELETE = "DELETE FROM hotel_room WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM hotel_room WHERE id=?";
    private static final String FIND_BY_PLACES = "SELECT * FROM hotel_room WHERE number_of_places=?";


    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<HotelRoom> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(HotelRoom.class));
    }

    @Override
    public Optional<HotelRoom> findById(Integer id) {
        Optional<HotelRoom> hotelRoom;
        try {
            hotelRoom = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(HotelRoom.class), id));
        } catch (EmptyResultDataAccessException e) {
            hotelRoom = Optional.empty();
        }
        return hotelRoom;
    }

    @Override
    public int create(HotelRoom hotelRoom) {
        return jdbcTemplate.update(CREATE, hotelRoom.getNumberOfPlaces(), hotelRoom.getIsFree(), hotelRoom.getPrice(), hotelRoom.getHotelId());
    }

    @Override
    public int update(Integer id, HotelRoom hotelRoom) {
        return jdbcTemplate.update(UPDATE, hotelRoom.getNumberOfPlaces(), hotelRoom.getIsFree(), hotelRoom.getPrice(), hotelRoom.getHotelId(), id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }

    @Override
    public Optional<HotelRoom> findByNumberOfPlaces(Integer numberOfPlaces) {
        Optional<HotelRoom> hotelRoom;
        try {
            hotelRoom = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_PLACES,
                    BeanPropertyRowMapper.newInstance(HotelRoom.class), numberOfPlaces));
        } catch (EmptyResultDataAccessException e) {
            hotelRoom = Optional.empty();
        }
        return hotelRoom;
    }
}


