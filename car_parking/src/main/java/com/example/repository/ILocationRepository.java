package com.example.repository;

import com.example.dto.CheckLocation;
import com.example.dto.ILocationDto;
import com.example.dto.LocationDto;
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


    /**
     * Created by: TanTH
     * Date created: 04/04/2023
     * Query: create location
     */

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

    /**
     * Created by: TanTH
     * Date created: 04/04/2023
     * Query: find location
     */

    @Query(value = "select * from location where id = :id and is_deleted = false", nativeQuery = true)
    Location findLocation(@Param("id") Long id);

    /**
     * Created by: TanTH
     * Date created: 04/04/2023
     * Query: list location
     */

    @Query(value = "select * from location", nativeQuery = true)
    List<Location> locationList();


    /**
     * Created by: TanTH
     * Date created: 04/04/2023
     * Function: update location
     */

    @Transactional
    @Modifying
    @Query(value = "update location set name = :name,width = :width, height = :height, length = :length,permission_car_type_locations = :permission_car_type_locations, floor_id = :floor_id,section_id = :section_id where id = :id",
            nativeQuery = true)

    void updateLocation(
    @Param("name") Long name ,
                        @Param("width") Double width ,
                        @Param("height") Double height,
                        @Param("length") Double length,
                        @Param("permission_car_type_locations") String permission_car_type_locations,
                        @Param("floor_id") Long floorId,
                        @Param("section_id") Long sectionId,
                        @Param("id") Long Id);


    /**
     * Created by: TanTH
     * Date created: 04/04/2023
     * Function: checkMaxName location
     */

    @Modifying
    @Transactional
    @Query(value = "select max(name) from `location` where floor_id = :floor_id and section_id = :section_id limit 1", nativeQuery = true)
    int[] checkMaxName(@Param("floor_id") Long floorId,@Param("section_id") Long sectionId);

    /**
     * Created by: TanTH
     * Date created: 04/04/2023
     * Function: create location
     */
    @Query(value = "select f.name as floorName, s.name as sectionName, location.name as locationName from location join floor f on f.id = location.floor_id join section s on s.id = location.section_id  where location.id =:id",nativeQuery = true)
    ILocationDto findLocationById(@Param("id") Long id);

}
