package com.izhyk.service;

import com.izhyk.domain.Reservation;

import java.util.Optional;

public interface ReservationService extends GeneralService<Reservation, Integer>{
    Optional<Reservation> findPaid(Boolean isPaid);
}
