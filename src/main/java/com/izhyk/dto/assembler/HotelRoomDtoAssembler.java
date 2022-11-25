package com.izhyk.dto.assembler;

import com.izhyk.controller.HotelRoomController;
import com.izhyk.domain.HotelRoom;

import com.izhyk.dto.HotelRoomDto;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@Component
public class HotelRoomDtoAssembler implements RepresentationModelAssembler<HotelRoom, HotelRoomDto> {
    @Override
    public HotelRoomDto toModel(HotelRoom entity) {
        HotelRoomDto reservationDto = HotelRoomDto.builder()
                .id(entity.getId())
                .isFree(entity.getIsFree())
                .numOfPlaces(entity.getNumberOfPlaces())
                .price(entity.getPrice())
                .build();
        Link selfLink = linkTo(methodOn(HotelRoomController.class).getHotelRoom(reservationDto.getId())).withSelfRel();
        reservationDto.add(selfLink);
        return reservationDto;
    }

    @Override
    public CollectionModel<HotelRoomDto> toCollectionModel(Iterable<? extends HotelRoom> entities) {
        CollectionModel<HotelRoomDto> hotelRoomDtos = RepresentationModelAssembler.super.toCollectionModel(entities);
        Link selfLink = linkTo(methodOn(HotelRoomController.class).getAllHotelRooms()).withSelfRel();
        hotelRoomDtos.add(selfLink);
        return hotelRoomDtos;
    }

    public CollectionModel<HotelRoomDto> toCollectionModel(Iterable<? extends HotelRoom> entities, Link link) {
        CollectionModel<HotelRoomDto> hotelRoomDtos = RepresentationModelAssembler.super.toCollectionModel(entities);
        hotelRoomDtos.add(link);
        return hotelRoomDtos;
    }
}