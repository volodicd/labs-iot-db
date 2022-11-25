package com.izhyk.dto.assembler;

import com.izhyk.controller.LocationController;
import com.izhyk.domain.Location;
import com.izhyk.dto.LocationDto;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class LocationDtoAssembler implements RepresentationModelAssembler<Location, LocationDto> {
    @Override
    public LocationDto toModel(Location entity) {
        LocationDto locationDto = LocationDto.builder()
                .id(entity.getId())
                .city(entity.getCity())
                .country(entity.getCountryName())
                .street(entity.getStreet())
                .build();
        Link selfLink = linkTo(methodOn(LocationController.class).getLocation(locationDto.getId())).withSelfRel();
        locationDto.add(selfLink);
        return locationDto;
    }

    @Override
    public CollectionModel<LocationDto> toCollectionModel(Iterable<? extends Location> entities) {
        CollectionModel<LocationDto> locationDtos = RepresentationModelAssembler.super.toCollectionModel(entities);
        Link selfLink = linkTo(methodOn(LocationController.class).getAllLocations()).withSelfRel();
        locationDtos.add(selfLink);
        return locationDtos;
    }

    public CollectionModel<LocationDto> toCollectionModel(Iterable<? extends Location> entities, Link link) {
        CollectionModel<LocationDto> locationDtos = RepresentationModelAssembler.super.toCollectionModel(entities);
        locationDtos.add(link);
        return locationDtos;
    }
}
