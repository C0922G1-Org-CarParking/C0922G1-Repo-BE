package com.example.repository.car_in_out;

import com.example.dto.ICarInOutDTO;
import com.example.model.CarInOut;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface ICarInOutRepository extends JpaRepository<CarInOut, Long> {
    @Query(value = "select\n" +
            "car.id as car_id, car.plate_number as car_plate_number, \t\t\n" +
            "car.name as car_name, car.brand as car_brand,     \t\t\n" +
            "car_type.name as car_type_name, customer.name as customer_name,\t\t\n" +
            "customer.phone_number as customer_phone_number, concat(section.name, location.name) as location_name, \t\t\n" +
            "floor.name as floor_name, ticket.effective_date as ticket_effective_date, ticket.expiry_date as ticket_expiry_date\t\t\n" +
            "from\t\t\n" +
            "car \t\t\n" +
            "join customer on car.customer_id = customer.id\t\t\n" +
            "join car_type on car.car_type_id = car_type.id\t\t\n" +
            "join ticket on ticket.car_id = car.id\t\t\n" +
            "join location on location.id = ticket.location_id\t\t\n" +
            "join floor on location.floor_id = floor.id\t\t\n" +
            "join section on location.section_id = section.id\t\t\n" +
            "where car.plate_number = :plateNumber and ticket.is_deleted = false", nativeQuery = true)
    ICarInOutDTO searchCarInOutDTO(@Param("plateNumber") String plateNumber);

    @Transactional
    @Query(value = "insert into car_in_out values (:carId, :timeIn, :timeOut)", nativeQuery = true)
    @Modifying
    void saveCarInOut(@Param("carId") long carId,
                      @Param("timeIn") String timeIn,
                      @Param("timeOut") String timeOut);
}
