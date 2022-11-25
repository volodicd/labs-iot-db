package com.izhyk.dto.assembler;

import com.izhyk.controller.ReservationController;
import com.izhyk.domain.Reservation;

import com.izhyk.dto.ReservationDto;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@Component
public class ReservationDtoAssembler implements RepresentationModelAssembler<Reservation, ReservationDto> {
    @Override
    public ReservationDto toModel(Reservation entity) {
        ReservationDto reservationDto = ReservationDto.builder()
                .id(entity.getId())
                .isPaid(entity.getIsPaid())
                .daysOfReservation(entity.getDaysOfRezervation())
                .build();
        Link selfLink = linkTo(methodOn(ReservationController.class).getReservation(reservationDto.getId())).withSelfRel();
        reservationDto.add(selfLink);
        return reservationDto;
    }

    @Override
    public CollectionModel<ReservationDto> toCollectionModel(Iterable<? extends Reservation> entities) {
        CollectionModel<ReservationDto> reservationDtos = RepresentationModelAssembler.super.toCollectionModel(entities);
        Link selfLink = linkTo(methodOn(ReservationController.class).getAllReservations()).withSelfRel();
        reservationDtos.add(selfLink);
        return reservationDtos;
    }

    public CollectionModel<ReservationDto> toCollectionModel(Iterable<? extends Reservation> entities, Link link) {
        CollectionModel<ReservationDto> reservationDtos = RepresentationModelAssembler.super.toCollectionModel(entities);
        reservationDtos.add(link);
        return reservationDtos;
    }
}