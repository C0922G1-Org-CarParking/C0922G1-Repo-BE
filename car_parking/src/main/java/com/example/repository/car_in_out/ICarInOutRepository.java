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

@Transactional
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

    @Query(value = "select car.id as carId," +
            "car.plate_number as carPlateNumber," +
            "car.name as carName," +
            "car.brand as carBrand," +
            "ct.name as cartypeName," +
            " c.name as customerName," +
            "c.phone_number as customerPhoneNumber," +
            " c.id_card as customerIdCard," +
            " t.effective_date as ticketEffectiveDate," +
            "t.expiry_date as ticketExpiryDarte," +
            "t.id as ticketId," +
            "l.name as locationName," +
            " s.name as sectionName," +
            "f.name as floorName from car " +
            "join car_type ct on ct.id = car.car_type_id " +
            "join customer c on c.id = car.customer_id " +
            "join ticket t on car.id = t.car_id " +
            "join location l on t.location_id = l.id " +
            "join section s on s.id = l.section_id " +
            "join floor f on f.id = l.floor_id  where car.id = :id"
            , nativeQuery = true)
//    Optional<ICarInOutDTO> findCarById(@Param("id") Long id);
    ICarInOutDTO findCarById(@Param("id") Long id);

    //    -----------------------------
    @Query(value = "SELECT " +
            "    cio.id," +
            "    ticket.id AS ticketId," +
            "    cio.time_in AS timeIn," +
            "    cio.time_out AS timeOut," +
            "    section.name as sectionName," +
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
            " FROM " +
            "    car " +
            "    right join ticket ON ticket.car_id = car.id" +
            "    right JOIN customer ON car.customer_id = customer.id " +
            "    right JOIN car_type ON car.car_type_id = car_type.id " +
            "    right JOIN location ON location.id = ticket.location_id" +
            "    right JOIN floor ON location.floor_id = floor.id" +
            "    right JOIN section ON location.section_id = section.id" +
            "    right join car_in_out cio ON car.id = cio.car_id" +
            " WHERE " +
            "    ticket.expiry_date >= CURRENT_DATE() " +
            "    AND car.is_deleted = 0" +
            "    AND cio.is_parked = 1 " +
            "    AND customer.name LIKE %:customerName% " +
            "    AND customer.phone_number LIKE %:customerPhoneNumber% " +
            "    AND car.plate_number LIKE %:carPlateNumber% ", nativeQuery = true)
    Page<ICarInOutDTO> searchCarInOutListDto(@Param("carPlateNumber") String carPlateNumber,
                                             @Param("customerName") String customerName,
                                             @Param("customerPhoneNumber") String customerPhoneNumber,
                                             Pageable pageable);
}
