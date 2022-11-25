package com.izhyk.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Reservation {
    private Integer id;
    private Integer daysOfReservation;
    private Boolean isPaid;
    private Integer hotelRoomId;
}
