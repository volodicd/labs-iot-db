package com.izhyk.dto.assembler;

import com.izhyk.controller.HotelController;
import com.izhyk.domain.Hotel;
import com.izhyk.dto.HotelDto;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@Component
public class HotelDtoAssembler implements RepresentationModelAssembler<Hotel, HotelDto> {
    @Override
    public HotelDto toModel(Hotel entity) {
        HotelDto hotelDto = HotelDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .numberOfRooms(entity.getNumberOfRooms())
                .build();
        Link selfLink = linkTo(methodOn(HotelController.class).getHotel(hotelDto.getId())).withSelfRel();
        hotelDto.add(selfLink);
        return hotelDto;
    }

    @Override
    public CollectionModel<HotelDto> toCollectionModel(Iterable<? extends Hotel> entities) {
        CollectionModel<HotelDto> hotelDto = RepresentationModelAssembler.super.toCollectionModel(entities);
        Link selfLink = linkTo(methodOn(HotelController.class).getAllHotels()).withSelfRel();
        hotelDto.add(selfLink);
        return hotelDto;
    }

    public CollectionModel<HotelDto> toCollectionModel(Iterable<? extends Hotel> entities, Link link) {
        CollectionModel<HotelDto> hotelDto = RepresentationModelAssembler.super.toCollectionModel(entities);
        hotelDto.add(link);
        return hotelDto;
    }
}
