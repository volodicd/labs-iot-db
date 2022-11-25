package com.izhyk.exception;

public class HotelsBranchNotFoundException extends RuntimeException {
    public HotelsBranchNotFoundException(Integer id) {
        super("Can't find hotels branch with id=" + id);
    }
}