package com.izhyk.controller.impl;

import com.izhyk.controller.ReservationController;
import com.izhyk.dao.ReservationDao;
import com.izhyk.domain.Reservation;
import com.izhyk.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationControllerImpl implements ReservationController {
    @Autowired
    private ReservationService reservationService ;

    @Override
    public List<Reservation> findAll() {
        return reservationService.findAll();
    }

    @Override
    public Optional<Reservation> findById(Integer id) {
        return reservationService.findById(id);
    }

    @Override
    public int create(Reservation reservation) {
        return reservationService.create(reservation);
    }

    @Override
    public int update(Integer id, Reservation reservation) {
        return reservationService.update(id, reservation);
    }

    @Override
    public int delete(Integer id) {
        return reservationService.delete(id);
    }

    @Override
    public Optional<Reservation> findPaid(Boolean isPaid) {
        return reservationService.findPaid(isPaid);
    }
}
