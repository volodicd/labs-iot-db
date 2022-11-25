package com.izhyk.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Reservation {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "days_of_rezervation")
    private Integer daysOfRezervation;
    @Basic
    @Column(name = "is_paid")
    private Byte isPaid;

    @ManyToOne
    @JoinColumn(name = "hotel_room_id", referencedColumnName = "id", nullable = false)
    private HotelRoom hotelRoomByHotelRoomId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDaysOfRezervation() {
        return daysOfRezervation;
    }

    public void setDaysOfRezervation(Integer daysOfRezervation) {
        this.daysOfRezervation = daysOfRezervation;
    }

    public Byte getIsPaid() {
        return isPaid;
    }

    public void setIsPaid(Byte isPaid) {
        this.isPaid = isPaid;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reservation that = (Reservation) o;
        return Objects.equals(id, that.id) && Objects.equals(daysOfRezervation, that.daysOfRezervation) && Objects.equals(isPaid, that.isPaid) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, daysOfRezervation, isPaid);
    }

    public HotelRoom getHotelRoomByHotelRoomId() {
        return hotelRoomByHotelRoomId;
    }

    public void setHotelRoomByHotelRoomId(HotelRoom hotelRoomByHotelRoomId) {
        this.hotelRoomByHotelRoomId = hotelRoomByHotelRoomId;
    }
}
