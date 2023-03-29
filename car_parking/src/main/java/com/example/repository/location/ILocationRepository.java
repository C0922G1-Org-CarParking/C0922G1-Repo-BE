package com.example.repository.location;

import com.example.dto.IFloorDto;
import com.example.dto.ILocationDto;
import com.example.model.Floor;
import com.example.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ILocationRepository extends JpaRepository<Location,Long> {

    @Query(value = "select f.id as id_floor, f.name as ten_tang from floor as f",
            nativeQuery = true)
    List<IFloorDto> getListNameFloor();


    @Query(value = "select location.id as Id, location.name as NameLocation  from location",
            nativeQuery = true)
    List<ILocationDto> getListNameLocation();


}
