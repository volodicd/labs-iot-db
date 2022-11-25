package com.izhyk.controller;

import com.izhyk.domain.HotelsBranch;
import com.izhyk.dto.HotelsBranchDto;
import com.izhyk.dto.assembler.HotelsBranchDtoAssembler;
import com.izhyk.service.HotelsBranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/hotelsBranches")
public class HotelsBranchController {
    @Autowired
    private HotelsBranchService hotelsBranchService;
    @Autowired
    private HotelsBranchDtoAssembler hotelsBranchDtoAssembler;

    @GetMapping(value = "/{hotelsBranchId}")
    public ResponseEntity<HotelsBranchDto> getHotelsBranch(@PathVariable Integer hotelsBranchId) {
        HotelsBranch hotelsBranch = hotelsBranchService.findById(hotelsBranchId);
        HotelsBranchDto hotelsBranchDto = hotelsBranchDtoAssembler.toModel(hotelsBranch);
        return new ResponseEntity<>(hotelsBranchDto, HttpStatus.OK);
    }

    @GetMapping(value = "")
    public ResponseEntity<CollectionModel<HotelsBranchDto>> getAllHotelsBranches() {
        List<HotelsBranch> hotelsBranches = hotelsBranchService.findAll();
        CollectionModel<HotelsBranchDto> hotelsBranchDtos = hotelsBranchDtoAssembler.toCollectionModel(hotelsBranches);
        return new ResponseEntity<>(hotelsBranchDtos, HttpStatus.OK);
    }



    @PostMapping(value = "")
    public ResponseEntity<HotelsBranchDto> addHotelsBranch(@RequestBody HotelsBranch hotelsBranch) {
        HotelsBranch newHotelsBranch = hotelsBranchService.create(hotelsBranch);
        HotelsBranchDto hotelsBranchDto = hotelsBranchDtoAssembler.toModel(newHotelsBranch);
        return new ResponseEntity<>(hotelsBranchDto, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{hotelsBranchId}")
    public ResponseEntity<?> updateHotelsBranch(@RequestBody HotelsBranch uHotelsBranch, @PathVariable Integer hotelsBranchId) {
        hotelsBranchService.update(hotelsBranchId, uHotelsBranch);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{hotelsBranchId}")
    public ResponseEntity<?> deleteHotelsBranch(@PathVariable Integer hotelsBranchId) {
        hotelsBranchService.delete(hotelsBranchId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
