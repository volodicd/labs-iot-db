package com.izhyk.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

@Builder
@Getter
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Relation(itemRelation = "hotel_room", collectionRelation = "hotel_rooms")
public class HotelRoomDto extends RepresentationModel<HotelRoomDto> {
    private final Integer id;
    private final Byte isFree;
    private final Integer numOfPlaces;
    private final Integer price;
}