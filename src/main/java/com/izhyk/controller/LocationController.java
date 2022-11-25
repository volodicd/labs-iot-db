package com.izhyk.controller;

import com.izhyk.domain.Location;
import com.izhyk.dto.LocationDto;
import com.izhyk.dto.ReservationDto;
import com.izhyk.dto.assembler.LocationDtoAssembler;
import com.izhyk.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/locations")
public class LocationController {
    @Autowired
    private LocationService locationService;
    @Autowired
    private LocationDtoAssembler locationDtoAssembler;

    @GetMapping(value = "/{locationId}")
    public ResponseEntity<LocationDto> getLocation(@PathVariable Integer locationId) {
        Location location = locationService.findById(locationId);
        LocationDto locationDto = locationDtoAssembler.toModel(location);
        return new ResponseEntity<>(locationDto, HttpStatus.OK);
    }

    @GetMapping(value = "")
    public ResponseEntity<CollectionModel<LocationDto>> getAllLocations() {
        List<Location> locations = locationService.findAll();
        CollectionModel<LocationDto> locationDtos = locationDtoAssembler.toCollectionModel(locations);
        return new ResponseEntity<>(locationDtos, HttpStatus.OK);
    }

    @GetMapping(value = "/city/{city}")
    public ResponseEntity<CollectionModel<LocationDto>> getLocationByCity(@PathVariable String сity) {
        List<Location> locations = locationService.findByCity(сity);
        CollectionModel<LocationDto> locationDtos = locationDtoAssembler.toCollectionModel(locations);
        return new ResponseEntity<>(locationDtos, HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<LocationDto> addLocation(@RequestBody Location location) {
        Location newLocation = locationService.create(location);
        LocationDto locationDto = locationDtoAssembler.toModel(newLocation);
        return new ResponseEntity<>(locationDto, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{locationId}")
    public ResponseEntity<?> updateLocation(@RequestBody Location uLocation, @PathVariable Integer locationId) {
        locationService.update(locationId, uLocation);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{locationId}")
    public ResponseEntity<?> deleteLocation(@PathVariable Integer locationId) {
        locationService.delete(locationId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
