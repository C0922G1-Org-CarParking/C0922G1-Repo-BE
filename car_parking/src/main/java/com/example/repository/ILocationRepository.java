package com.example.repository;

import com.example.dto.ILocationDetailDto;
import com.example.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
public interface ILocationRepository extends JpaRepository<Location, Integer> {
    @Query(value = "select * from location\n" +
            " left join floor on floor.id=location.floor_id\n" +
            " left join section on section.id= location.section_id where floor_id=:id", nativeQuery = true)
    List<Location> listMapParking(@Param("id") int id);

    @Query(value = "select location.name as locationName , floor.name as floorName, section.name as sectionName,\n" +
            " location.height as locationHeight , location.width as locationWidth, location.length as locationLength, permission_car_type_locations as permissionCarTypeLocations" +
            "customer.name as customerName, \n" +
            " customer.email as customerEmail, customer.phone_number as customerPhoneNumber from location\n" +
            " left join floor on floor.id=location.floor_id\n" +
            " left join section on section.id= location.section_id\n" +
            " left join ticket on location.id=ticket.location_id\n" +
            " left join car on car.id=ticket.car_id\n" +
            " left join customer on car.customer_id=customer.id where location.id=:id and ticket.expiry_date >=curdate()  ", nativeQuery = true)
    ILocationDetailDto findByIdLocation(@Param("id") int id);


    @Modifying
    @Query(value = "update location join ticket on location.id= ticket.location_id set location.is_occupied = 0 where ticket.expiry_date < curdate()" , nativeQuery = true)
    void resetIsOccupiedLocationToFalse();
    @Modifying
    @Query(value = "update location join ticket on location.id = ticket.location_id set location.is_occupied=1 where ticket.expiry_date >= curdate()",nativeQuery = true)
    void resetIsOccupiedLocationToTrue();
}
