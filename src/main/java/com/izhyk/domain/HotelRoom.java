package com.izhyk.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class HotelRoom {
private Integer id;
private Integer numberOfPlaces;
private Boolean isFree;
private Integer price;
private Integer hotelId;
}
