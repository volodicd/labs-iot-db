package com.izhyk.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Location {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "city")
    private String city;
    @Basic
    @Column(name = "street")
    private String street;
    @Basic
    @Column(name = "country_name")
    private String countryName;
    @OneToMany(mappedBy = "location")
    private List<HotelsBranch> hotelsBranches;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return Objects.equals(id, location.id) && Objects.equals(city, location.city) && Objects.equals(street, location.street) && Objects.equals(countryName, location.countryName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, city, street, countryName);
    }

    public List<HotelsBranch> getHotelsBranches() {
        return hotelsBranches;
    }

    public void setHotelsBranches(List<HotelsBranch> hotelsBranches) {
        this.hotelsBranches = hotelsBranches;
    }
}
