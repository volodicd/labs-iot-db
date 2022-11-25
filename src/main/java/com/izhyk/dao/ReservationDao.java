package com.izhyk.dao;

import com.izhyk.dao.GeneralDao;
import com.izhyk.domain.Reservation;


import java.util.Optional;

public interface ReservationDao extends GeneralDao<Reservation, Integer> {
    Optional<Reservation> findPaid(Boolean isPaid);
}
