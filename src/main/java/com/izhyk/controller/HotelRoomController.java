package com.izhyk.controller;

import com.izhyk.domain.HotelRoom;
import com.izhyk.dto.HotelRoomDto;
import com.izhyk.dto.assembler.HotelRoomDtoAssembler;
import com.izhyk.service.HotelRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/hotelRooms")
public class HotelRoomController {

    @Autowired
    private HotelRoomService hotelRoomService;
    @Autowired
    private HotelRoomDtoAssembler hotelRoomDtoAssembler;

    @GetMapping(value = "/{hotelRoomId}")
    public ResponseEntity<HotelRoomDto> getHotelRoom(@PathVariable Integer hotelRoomId) {
        HotelRoom hotelRoom = hotelRoomService.findById(hotelRoomId);
        HotelRoomDto hotelRoomDto = hotelRoomDtoAssembler.toModel(hotelRoom);
        return new ResponseEntity<>(hotelRoomDto, HttpStatus.OK);
    }

    @GetMapping(value = "")
    public ResponseEntity<CollectionModel<HotelRoomDto>> getAllHotelRooms() {
        List<HotelRoom> hotelRooms = hotelRoomService.findAll();
        CollectionModel<HotelRoomDto> hotelRoomDtos = hotelRoomDtoAssembler.toCollectionModel(hotelRooms);
        return new ResponseEntity<>(hotelRoomDtos, HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<HotelRoomDto> addHotelRoom(@RequestBody HotelRoom hotelRoom) {
        HotelRoom newHotelRoom = hotelRoomService.create(hotelRoom);
        HotelRoomDto bookDto = hotelRoomDtoAssembler.toModel(newHotelRoom);
        return new ResponseEntity<>(bookDto, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{hotelRoomId}")
    public ResponseEntity<?> updateHotelRoom(@RequestBody HotelRoom uHotelRoom, @PathVariable Integer hotelRoomId) {
        hotelRoomService.update(hotelRoomId, uHotelRoom);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{hotelRoomId}")
    public ResponseEntity<?> deleteHotelRoom(@PathVariable Integer hotelRoomId) {
        hotelRoomService.delete(hotelRoomId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
