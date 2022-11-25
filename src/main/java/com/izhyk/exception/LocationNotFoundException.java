package com.izhyk.exception;

public class LocationNotFoundException extends RuntimeException {
    public LocationNotFoundException(Integer id) {
        super("Can't find location with id=" + id);
    }
}