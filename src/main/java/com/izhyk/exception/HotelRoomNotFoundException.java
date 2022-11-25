package com.izhyk.exception;

public class HotelRoomNotFoundException extends RuntimeException {
    public HotelRoomNotFoundException(Integer id) {
        super("Can't find hotel room with id=" + id);
    }
}
