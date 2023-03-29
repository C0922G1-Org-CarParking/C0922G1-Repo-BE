package com.example.repository.car_in_out;

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
            "            floor_id,\n" +
            "            section_id,\n" +
            "            is_occupied,\n" +
            "            is_deleted)\n" +
            "            value\n" +
            "            (:name,\n" +
            "            :width,\n" +
            "            :height,\n" +
            "            :length,\n" +
            "            :floor_id,\n" +
            "            :section_id,\n" +
            "             false ,\n" +
            "             false)",
            nativeQuery = true)
    void addLocation(
            @Param("name") String name,
            @Param("width") Double width,
            @Param("height") Double height,
            @Param("length") Double length,
            @Param("floor_id") Long floorId,
            @Param("section_id") Long sectionId);

    @Query(value = "select * from location where id = :id and is_deleted = false", nativeQuery = true)
    Location findLocation(@Param("id") Long id);

    @Query(value = "select * from location", nativeQuery = true)
    List<Location> locationList();


    @Modifying
    @Transactional
    @Query(value = "update location set\n" +
            "            name = :name,\n" +
            "            width = :width,\n" +
            "                   height = :height,\n" +
            "                   length = :length,\n" +
            "                   floor_id = :floor_id,\n" +
            "                   section_id = :section_id\n" +
            "                   where id = :id",
            nativeQuery = true)

    void updateLocation(@Param("name") String name , @Param("width") Double width , @Param("height") Double height, @Param("length") Double length, @Param("floor_id") Long floorId, @Param("section_id") Long sectionId ,@Param("id") Long Id);

}
