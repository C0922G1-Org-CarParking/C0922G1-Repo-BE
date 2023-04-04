package com.example.repository;

import com.example.dto.ICarInOutDTO;
import com.example.model.CarInOut;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

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
}
