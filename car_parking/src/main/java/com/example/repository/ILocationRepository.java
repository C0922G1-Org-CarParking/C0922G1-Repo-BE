package com.example.repository;

import com.example.dto.IFloorDto;
import com.example.dto.ILocationDto;
import com.example.dto.ILocationOfFloor;
import com.example.model.Floor;
import com.example.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ILocationRepository extends JpaRepository<Location,Long> {

    @Query(value = "select f.id as id, f.name as name from floor as f",
            nativeQuery = true)
    List<IFloorDto> getListNameFloor();


    @Query(value = "select location.id as id, location.name as name from location " +
            "join `section` on `section`.id = location.section_id" +
            " join floor on floor.id = location.floor_id" +
            " where `section`.id = :floorId and floor.id = :sectionId",
            nativeQuery = true)
    List<ILocationOfFloor> getListNameLocation(@Param("floorId") int floorId ,
                                               @Param("sectionId") int sectionId);


}
