package com.example.repository.location;

import com.example.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ILocationRepository extends JpaRepository<Location,Long> {

    @Query(value = "select floor.id, floor.name as ten_tang from location join floor on location.floor_id = floor.id ",
            nativeQuery = true)
    void getListNameFloor();


    @Query(value = "select location.id, location.name as ten_vi_tri  from location",
            nativeQuery = true)
    void getListNameLocation();


}
