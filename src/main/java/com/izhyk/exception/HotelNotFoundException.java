package com.izhyk.exception;

public class HotelNotFoundException extends RuntimeException {
    public HotelNotFoundException(Integer id) {
        super("Can't find hotel  with id=" + id);
    }
}