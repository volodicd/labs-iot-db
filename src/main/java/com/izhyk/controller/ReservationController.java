package com.izhyk.controller;


import com.izhyk.domain.Reservation;

import java.util.Optional;

public interface ReservationController extends GeneralController<Reservation, Integer> {
    Optional<Reservation> findPaid(Boolean isPaid);
}
