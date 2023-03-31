package com.example.repository.car_in_out;

import com.example.dto.ICarInOutDTO;
import com.example.model.CarInOut;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface ICarInOutRepository extends JpaRepository<CarInOut, Long> {
    @Query(value = "select" +
            "car.name as car_name, car.brand as car_brand,    " +
            "car_type.name as car_type_name, customer.name as customer_name," +
            "customer.phone_number as customer_phone_number, concat(section.name, location.name) as location_name," +
            "floor.name as floor_name, ticket.effective_date as ticket_effective_date, ticket.expiry_date as ticket_expiry_date" +
            "from" +
            "car " +
            "join customer on car.customer_id = customer.id" +
            "join car_type on car.car_type_id = car_type.id" +
            "join ticket on ticket.car_id = car.id" +
            "join location on location.id = ticket.location_id" +
            "join floor on location.floor_id = floor.id" +
            "join section on location.section_id = section.id" +
            "where car.plate_number = :plateNumber;", nativeQuery = true)
    ICarInOutDTO searchCarInOutDTO(@Param("plateNumber") String plateNumber);

    @Transactional
    @Query(value = "insert into car_in_out values (:carId, :timeIn, :timeOut)", nativeQuery = true)
    @Modifying
    void saveCarInOut(@Param("carId") long carId,
                      @Param("timeIn") String timeIn,
                      @Param("timeOut") String timeOut);


    /**
     * Created by: HuyNL
     * Date created: 29/03/2023
     * Function: searchCar and showList Car
     */

    @Query(value = "select * from car where car.id = :id"
            , nativeQuery = true)
    Optional<ICarInOutDTO> findCarById(@Param("id") Long id);


    @Query(value = " select " +
            "ticket.id AS ticket_id, " +
            "car.id AS carId, " +
            "car.plate_number AS carPlateNumber, " +
            "customer.id_card AS customerIdCard, " +
            "car.name AS carName, " +
            "car.brand AS carBrand, " +
            "car_type.name AS carTypeName, " +
            "customer.name AS customerName, " +
            "customer.phone_number AS customerPhoneNumber, " +
            "CONCAT(section.name, location.name) AS locationName, " +
            "floor.name AS floorName, " +
            "ticket.effective_date AS ticketEffectiveDate, " +
            "ticket.expiry_date AS ticketExpiryDate " +
            "FROM car " +
            "JOIN ticket ON ticket.car_id = car.id " +
            "JOIN customer ON car.customer_id = customer.id " +
            "JOIN car_type ON car.car_type_id = car_type.id " +
            "JOIN location ON location.id = ticket.location_id " +
            "JOIN floor ON location.floor_id = floor.id " +
            "JOIN section ON location.section_id = section.id " +
            "JOIN car_in_out cio ON car.id = cio.car_id " +
            "WHERE ticket.expiry_date >= CURRENT_DATE() " +
            "AND car.plate_number LIKE %:plateNumber% " +
            "AND cio.is_parked = 1 " +
            "AND car.is_deleted = 0 " +
            "AND customer.name like %:customerName% " +
            "AND customer.phone_number like %:customerPhoneNumber%", nativeQuery = true)
    Page<ICarInOutDTO> searchCarIn(@Param("plateNumber") String plateNumber,
                                   @Param("customerName") String customerName,
                                   @Param("customerPhoneNumber") String customerPhoneNumber,
                                   Pageable pageable);

    @Query(value = "SELECT " +
            "    cio.id," +
            "    ticket.id AS ticket_id," +
            "    cio.time_in AS timeIn," +
            "    car.id AS carId," +
            "    car.plate_number AS carPlateNumber," +
            "    customer.id_card AS customerIdCard, " +
            "    car.name AS carName," +
            "    car.brand AS carBrand,  " +
            "    car_type.name AS carTypeName," +
            "    customer.name AS customerName," +
            "    customer.phone_number AS customerPhoneNumber," +
            "    CONCAT(section.name, location.name) AS locationName, " +
            "    floor.name AS floorName," +
            "    ticket.effective_date AS ticketEffectiveDate," +
            "    ticket.expiry_date AS ticketExpiryDate" +
            "FROM " +
            "    car " +
            "    JOIN ticket ON ticket.car_id = car.id" +
            "    JOIN customer ON car.customer_id = customer.id " +
            "    JOIN car_type ON car.car_type_id = car_type.id " +
            "    JOIN location ON location.id = ticket.location_id" +
            "    JOIN floor ON location.floor_id = floor.id" +
            "    JOIN section ON location.section_id = section.id" +
            "    JOIN car_in_out cio ON car.id = cio.car_id" +
            "WHERE " +
            "    ticket.expiry_date >= CURRENT_DATE() " +
            "    AND car.plate_number LIKE '%%' " +
            "    AND cio.is_parked = 1 " +
            "    AND car.is_deleted = 0" +
            "    AND customer.name like '%%'" +
            "    AND customer.phone_number like '%%'",nativeQuery = true)

    Page<ICarInOutDTO> searchCarOutDto(@Param("plateNumber") String plateNumber, @Param("customerName") String customerName,@Param("customerPhoneNumber") String customerPhoneNumber, Pageable pageable);

}
