package com.izhyk.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Hotel {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "number_of_rooms")
    private Integer numberOfRooms;

    @ManyToOne
    @JoinColumn(name = "hotels_branch_id", referencedColumnName = "id", nullable = false)
    private HotelsBranch hotelsBranchByHotelsBranchId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(Integer numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hotel hotel = (Hotel) o;
        return Objects.equals(id, hotel.id) && Objects.equals(name, hotel.name) && Objects.equals(numberOfRooms, hotel.numberOfRooms) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, numberOfRooms);
    }

    public HotelsBranch getHotelsBranchByHotelsBranchId() {
        return hotelsBranchByHotelsBranchId;
    }

    public void setHotelsBranchByHotelsBranchId(HotelsBranch hotelsBranchByHotelsBranchId) {
        this.hotelsBranchByHotelsBranchId = hotelsBranchByHotelsBranchId;
    }
}
