package com.izhyk.domain;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "hotel_room", schema = "lab5_db", catalog = "")
public class HotelRoom {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "number_of_places")
    private Integer numberOfPlaces;
    @Basic
    @Column(name = "is_free")
    private Byte isFree;
    @Basic
    @Column(name = "price")
    private Integer price;

    @ManyToOne
    @JoinColumn(name = "hotel_id", referencedColumnName = "id", nullable = false)
    private Hotel hotelByHotelId;
    @OneToMany(mappedBy = "hotelRoomByHotelRoomId")
    private Collection<Reservation> reservationsById;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumberOfPlaces() {
        return numberOfPlaces;
    }

    public void setNumberOfPlaces(Integer numberOfPlaces) {
        this.numberOfPlaces = numberOfPlaces;
    }

    public Byte getIsFree() {
        return isFree;
    }

    public void setIsFree(Byte isFree) {
        this.isFree = isFree;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HotelRoom hotelRoom = (HotelRoom) o;
        return Objects.equals(id, hotelRoom.id) && Objects.equals(numberOfPlaces, hotelRoom.numberOfPlaces) && Objects.equals(isFree, hotelRoom.isFree) && Objects.equals(price, hotelRoom.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numberOfPlaces, isFree, price);
    }

    public Hotel getHotelByHotelId() {
        return hotelByHotelId;
    }

    public void setHotelByHotelId(Hotel hotelByHotelId) {
        this.hotelByHotelId = hotelByHotelId;
    }

    public Collection<Reservation> getReservationsById() {
        return reservationsById;
    }

    public void setReservationsById(Collection<Reservation> reservationsById) {
        this.reservationsById = reservationsById;
    }
}
