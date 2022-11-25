package com.izhyk.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "hotels_branch", schema = "lab5_db", catalog = "")
public class HotelsBranch {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "number_of_hotels")
    private Integer numberOfHotels;
    @Basic
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "hotelsBranchByHotelsBranchId")
    private List<Hotel> hotels;
    @ManyToOne
    @JoinColumn(name = "location_id", referencedColumnName = "id", nullable = false)
    private Location location;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumberOfHotels() {
        return numberOfHotels;
    }

    public void setNumberOfHotels(Integer numberOfHotels) {
        this.numberOfHotels = numberOfHotels;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HotelsBranch that = (HotelsBranch) o;
        return Objects.equals(id, that.id) && Objects.equals(numberOfHotels, that.numberOfHotels) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numberOfHotels, name);
    }

    public List<Hotel> getHotels() {
        return hotels;
    }

    public void setHotels(List<Hotel> hotels) {
        this.hotels = hotels;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
