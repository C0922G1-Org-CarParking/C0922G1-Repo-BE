package com.example.repository;

import com.example.dto.ICarInOutDTO;
import com.example.model.CarInOut;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface ICarInOutRepository extends JpaRepository<CarInOut, Long> {
    @Query(value = "SELECT " +
            "    cio.id," +
            "    ticket.id AS ticket_id," +
            "    cio.time_in AS timeIn," +
            "    cio.time_out AS timeOut," +
            "    section.name as sectioneName," +
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
            "   " +
            "     car.is_deleted = 0" +
            "    AND customer.name LIKE %:customerName%" +
            "    AND customer.phone_number LIKE %:customerPhoneNumber%" +
            "    AND car.plate_number LIKE %:carPlateNumber%", nativeQuery = true)
    List<ICarInOutDTO> searchCarInOutDtoByNameByCustomerNameByPhoneNumber(@Param("carPlateNumber") String carPlateNumber,
                                                                          @Param("customerName") String customerName,
                                                                          @Param("customerPhoneNumber") String customerPhoneNumber);
}
