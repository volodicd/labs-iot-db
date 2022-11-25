package com.izhyk.service.impl;

import com.izhyk.domain.Location;
import com.izhyk.domain.Reservation;
import com.izhyk.exception.ReservationNotFoundException;
import com.izhyk.repository.LocationRepository;
import com.izhyk.repository.ReservationRepository;
import com.izhyk.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {
    @Autowired
    ReservationRepository reservationRepository;


    public List<Reservation> findAll() {
        return reservationRepository.findAll();
    }


    public Reservation findById(Integer id) {
        return reservationRepository.findById(id)
                .orElseThrow(() -> new ReservationNotFoundException(id));
    }

    @Transactional
    public Reservation create(Reservation reservation) {
        reservationRepository.save(reservation);
        return reservation;
    }

    @Transactional
    public void update(Integer id,  Reservation ureservation) {

        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new ReservationNotFoundException(id));
        //update
        reservation.setDaysOfRezervation(ureservation.getDaysOfRezervation());
        reservation.setIsPaid(ureservation.getIsPaid());

        reservationRepository.save(reservation);
    }

    @Transactional
    public void delete(Integer id) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new ReservationNotFoundException(id));
        reservationRepository.delete(reservation);
    }


}
