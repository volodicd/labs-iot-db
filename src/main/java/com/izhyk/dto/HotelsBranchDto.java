package com.izhyk.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import java.util.List;


@Builder
@Getter
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Relation(itemRelation = "hotels_branch", collectionRelation = "hotels_branchs")
public class HotelsBranchDto extends RepresentationModel<HotelsBranchDto> {
    private final Integer id;
    private final String name;
    private final List numOfHotels;
}