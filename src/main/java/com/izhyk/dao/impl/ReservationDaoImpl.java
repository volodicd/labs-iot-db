package com.izhyk.dao.impl;

import com.izhyk.dao.ReservationDao;

import com.izhyk.domain.Reservation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("SqlResolve")
@Service

public class ReservationDaoImpl implements ReservationDao {
    private static final String FIND_ALL = "SELECT * FROM reservation";
    private static final String CREATE = "INSERT reservation(days_of_rezervation, is_paid, hotel_room_id) VALUES (?, ?, ?)";
    private static final String UPDATE = "UPDATE reservation SET days_of_rezervation=?, is_paid=?,hotel_room_id=?  WHERE id=?";
    private static final String DELETE = "DELETE FROM reservation WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM reservation WHERE id=?";

    private static final String FIND_BY_PAID = "SELECT * FROM reservation WHERE is_paid=?";


    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Reservation> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(Reservation.class));
    }

    @Override
    public Optional<Reservation> findById(Integer id) {
        Optional<Reservation> reservation;
        try {
            reservation = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(Reservation.class), id));
        } catch (EmptyResultDataAccessException e) {
            reservation = Optional.empty();
        }
        return reservation;
    }

    @Override
    public int create(Reservation reservation) {
        return jdbcTemplate.update(CREATE, reservation.getDaysOfReservation(), reservation.getIsPaid(), reservation.getHotelRoomId());
    }

    @Override
    public int update(Integer id, Reservation reservation) {
        return jdbcTemplate.update(UPDATE, reservation.getDaysOfReservation(), reservation.getIsPaid(), reservation.getHotelRoomId(), id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }

    @Override
    public Optional<Reservation> findPaid(Boolean isPaid) {
        Optional<Reservation> reservation;
        try {
            reservation = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_PAID,
                    BeanPropertyRowMapper.newInstance(Reservation.class), isPaid));
        } catch (EmptyResultDataAccessException e) {
            reservation = Optional.empty();
        }
        return reservation;
    }


}