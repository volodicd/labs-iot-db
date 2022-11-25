package com.izhyk.dto.assembler;

import com.izhyk.controller.HotelsBranchController;
import com.izhyk.domain.HotelsBranch;
import com.izhyk.domain.Reservation;
import com.izhyk.dto.HotelsBranchDto;
import com.izhyk.dto.ReservationDto;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@Component
public class HotelsBranchDtoAssembler implements RepresentationModelAssembler<HotelsBranch, HotelsBranchDto> {
    @Override
    public HotelsBranchDto toModel(HotelsBranch entity) {
        HotelsBranchDto hotelsBranchDto = HotelsBranchDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .numOfHotels(entity.getHotels())
                .build();
        Link selfLink = linkTo(methodOn(HotelsBranchController.class).getHotelsBranch(hotelsBranchDto.getId())).withSelfRel();
        hotelsBranchDto.add(selfLink);
        return hotelsBranchDto;
    }

    @Override
    public CollectionModel<HotelsBranchDto> toCollectionModel(Iterable<? extends HotelsBranch> entities) {
        CollectionModel<HotelsBranchDto> hotelsBranchDtos = RepresentationModelAssembler.super.toCollectionModel(entities);
        Link selfLink = linkTo(methodOn(HotelsBranchController.class).getAllHotelsBranches()).withSelfRel();
        hotelsBranchDtos.add(selfLink);
        return hotelsBranchDtos;
    }

    public CollectionModel<HotelsBranchDto> toCollectionModel(Iterable<? extends HotelsBranch> entities, Link link) {
        CollectionModel<HotelsBranchDto> hotelsBranchDtos = RepresentationModelAssembler.super.toCollectionModel(entities);
        hotelsBranchDtos.add(link);
        return hotelsBranchDtos;
    }
}