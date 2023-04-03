package com.example.repository;


import com.example.dto.ILocationDetailDto;
import com.example.dto.CheckLocation;
import com.example.dto.ILocationDto;
import com.example.dto.ILocationView;
import com.example.model.Location;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Transactional
public interface ILocationRepository extends JpaRepository<Location, Long> {

// Created by: TheNV
    @Query(value = "select * from location\n" +
            " left join floor on floor.id=location.floor_id\n" +
            " left join section on section.id= location.section_id where floor_id=:id and location.is_deleted=false order by location.section_id ,location.name", nativeQuery = true)
    List<Location> listLocation(@Param("id") int id);
// Created by: TheNV

    @Query(value = " select location.name as locationName , floor.name as floorName, section.name as sectionName,\n" +
            " customer.name as customerName, car.name as nameCar,car_type.name as nameCarType,car.plate_number as plateNumber,\n" +
            " customer.email as customerEmail,customer.date_of_birth as dateOfBirth, customer.phone_number as customerPhoneNumber from location\n" +
            " left join floor on floor.id=location.floor_id\n" +
            " left join section on section.id= location.section_id\n" +
            " left join ticket on location.id=ticket.location_id\n" +
            " left join car on car.id=ticket.car_id\n" +
            " left join car_type on car_type.id=car.car_type_id\n" +
            " left join customer on car.customer_id=customer.id where location.id=:id  and ticket.expiry_date >=curdate()    ", nativeQuery = true)
    ILocationDetailDto findLocationById(@Param("id") int id);
// Created by: TheNV


    @Modifying
    @Query(value = "update location join ticket on location.id= ticket.location_id set location.is_occupied = 0 where ticket.expiry_date < curdate()", nativeQuery = true)
    void resetIsOccupiedLocationToFalse();
// Created by: TheNV

    @Modifying
    @Query(value = "update location join ticket on location.id = ticket.location_id set location.is_occupied=1 where ticket.expiry_date >= curdate()", nativeQuery = true)
    void resetIsOccupiedLocationToTrue();
// Created by: TheNV

    @Query(value = "select * from location where location.id=:id", nativeQuery = true)
    Location findLocationEmptyById(@Param("id") int id);
    // Created by: TanTH
    @Modifying
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
            @Param("name") Long name,
            @Param("width") Double width,
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

    @Query(value = "select f.name as floorName, s.name as sectionName, location.name as locationName from location join floor f on f.id = location.floor_id join section s on s.id = location.section_id  where location.id =:id", nativeQuery = true)
    ILocationView findLocationById(@Param("id") Long id);
    // Created by: TanTH


//    BaoHX
    @Modifying
    @Query(value = "update `location` as l set l.is_deleted = true where l.id= :id", nativeQuery = true)
    void deleteLocation(@Param("id") Long id);


    @Query(value =
            "select l.id as id, \n" +
                    "                                    f.name as nameFloor, \n" +
                    "                                   l.floor_id as floorId, \n" +
                    "                                   l.section_id as sectionId, \n" +
                    "                                   l.length as length, \n" +
                    "                                   l.width as width, \n" +
                    "                                   l.height as height,\n" +
                    "                                    s.name as nameSection\n" +
                    "                                    from `c0922g1_car_parking`.location l \n" +
                    "                                    join floor f on f.id = l.floor_id \n" +
                    "                                    join section s on l.section_id = s.id\n" +
                    "                            where f.name like concat('%', :search , '%') \n" +
                    "                                                        and l.is_deleted = false ",
            countQuery =
                    "select l.id as id, \n" +
                            "                                    f.name as nameFloor, \n" +
                            "                                   l.floor_id as floorId, \n" +
                            "                                   l.section_id as sectionId, \n" +
                            "                                   l.length as length, \n" +
                            "                                   l.width as width, \n" +
                            "                                   l.height as height,\n" +
                            "                                    s.name as nameSection\n" +
                            "                                    from `c0922g1_car_parking`.location l \n" +
                            "                                    join floor f on f.id = l.floor_id \n" +
                            "                                    join section s on l.section_id = s.id\n" +
                            "                            where f.name like concat('%', :search , '%') \n" +
                            "                                                        and l.is_deleted = false ",
            nativeQuery = true )
    Page<ILocationDto>showListT(Pageable pageable, @Param("search") String search);

}
