package com.izhyk.repository;

import com.izhyk.domain.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LocationRepository extends JpaRepository<Location, Integer> {

    List<Location> findByCity(String city);


    @Query("SELECT l FROM Location l WHERE l.city=?1 AND l.street=?2")
    Location findByCityAndStreetName (@Param("city") String city, @Param ("street") String street);
}
