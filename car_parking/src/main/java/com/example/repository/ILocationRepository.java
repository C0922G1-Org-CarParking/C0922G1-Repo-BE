package com.example.repository;

import com.example.dto.CheckLocation;
import com.example.dto.ILocationDto;
import com.example.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public interface ILocationRepository extends JpaRepository<Location, Integer> {
     @Modifying
    @Transactional
    @Query(value = "insert into location(\n" +
            "            name,\n" +
            "            width,\n" +
            "            height,\n" +
            "            length,\n" +
            "            permission_car_type_locations,\n" +
            "            floor_id,\n" +
            "            section_id,\n" +
            "            is_occupied,\n" +
            "            is_deleted)\n" +
            "            value\n" +
            "            (:name,\n" +
            "            :width,\n" +
            "            :height,\n" +
            "            :length,\n" +
            "            :permission_car_type_locations,\n" +
            "            :floor_id,\n" +
            "            :section_id,\n" +
            "             false ,\n" +
            "             false)",
            nativeQuery = true)
    void addLocation(
            @Param("name") Long name,
            @Param("width") Double width,
            @Param("height") Double height,
            @Param("length") Double length,
            @Param("permission_car_type_locations") String permissionCarTypeLocations,
            @Param("floor_id") Long floorId,
            @Param("section_id") Long sectionId);

    @Query(value = "select * from location where id = :id and is_deleted = false", nativeQuery = true)
    Location findLocation(@Param("id") Long id);

    @Query(value = "select * from location", nativeQuery = true)
    List<Location> locationList();




    @Transactional
    @Modifying
    @Query(value = "update location  set name = :name,width = :width, height = :height, length = :length, floor_id = :floor_id,section_id = :section_id where id = :id",
            nativeQuery = true)

    void updateLocation(
    @Param("name") Long name ,
                        @Param("width") Double width ,
                        @Param("height") Double height,
                        @Param("length") Double length,
                        @Param("floor_id") Long floorId,
                        @Param("section_id") Long sectionId,
                        @Param("id") Long Id);


    @Modifying
    @Transactional
    @Query(value = "select count(floor_id) from location where floor_id = :floor_id ", nativeQuery = true)
    void checkFloor(@Param("floor_id") Long floorId);

    @Modifying
    @Transactional
    @Query(value = "select count(section_id) from  location where floor_id = :floor_id and section_id = :section_id ", nativeQuery = true)
    void checkSection(@Param("floor_id") Long floorId, @Param("section_id") Long sectionId);
    @Modifying
    @Transactional
    @Query(value = "select max(name) as name from location", nativeQuery = true)
    CheckLocation checkName();

    @Query(value = "select f.name as floorName, s.name as sectionName, location.name as locationName from location join floor f on f.id = location.floor_id join section s on s.id = location.section_id  where location.id =:id",nativeQuery = true)
    ILocationDto findLocationById(@Param("id") Long id);

}
