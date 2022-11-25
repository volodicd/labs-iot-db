package com.izhyk.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class HotelsBranch {
    private Integer id;
    private Integer numberOfHotels;
    private String name;
    private Integer locationId;
}
