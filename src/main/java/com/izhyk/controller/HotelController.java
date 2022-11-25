package com.izhyk.controller;

import com.izhyk.domain.Hotel;
import com.izhyk.dto.HotelDto;
import com.izhyk.dto.assembler.HotelDtoAssembler;
import com.izhyk.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/hotels")
public class HotelController {
    @Autowired
    private HotelService hotelService;
    @Autowired
    private HotelDtoAssembler hotelDtoAssembler;

    @GetMapping(value = "/{hotelId}")
    public ResponseEntity<HotelDto> getHotel(@PathVariable Integer hotelId) {
        Hotel hotel = hotelService.findById(hotelId);
        HotelDto hotelDto = hotelDtoAssembler.toModel(hotel);
        return new ResponseEntity<>(hotelDto, HttpStatus.OK);
    }

    @GetMapping(value = "")
    public ResponseEntity<CollectionModel<HotelDto>> getAllHotels() {
        List<Hotel> books = hotelService.findAll();
        CollectionModel<HotelDto> hotelDtos = hotelDtoAssembler.toCollectionModel(books);
        return new ResponseEntity<>(hotelDtos, HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<HotelDto> addHotel(@RequestBody Hotel hotel) {
        Hotel newHotel = hotelService.create(hotel);
        HotelDto hotelDto = hotelDtoAssembler.toModel(newHotel);
        return new ResponseEntity<>(hotelDto, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{hotelId}")
    public ResponseEntity<?> updateHotel(@RequestBody Hotel uHotel, @PathVariable Integer hotelId) {
        hotelService.update(hotelId, uHotel);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{hotelId}")
    public ResponseEntity<?> deleteHotel(@PathVariable Integer hotelId) {
        hotelService.delete(hotelId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
