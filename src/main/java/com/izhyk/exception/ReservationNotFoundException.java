package com.izhyk.exception;

public class ReservationNotFoundException extends RuntimeException {
    public ReservationNotFoundException(Integer id) {
        super("Can't find reservation with id=" + id);
    }
}