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
@Relation(itemRelation = "reservation", collectionRelation = "reservations")
public class ReservationDto extends RepresentationModel<ReservationDto> {
    private final Integer id;
    private final Byte isPaid;
    private final Integer daysOfReservation;
}
