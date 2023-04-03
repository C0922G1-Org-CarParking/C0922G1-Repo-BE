package com.example.repository;

import com.example.dto.ICarInOutDTO;
import com.example.model.CarInOut;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface ICarInOutRepository extends JpaRepository<CarInOut, Long> {


    @Query(value =
            "select\n" +
                    "            car.id as carId, car.plate_number as carPlateNumber,\n" +
                    "            car.name as carName, car.brand as carBrand,\n" +
                    "            car_type.name as carTypeName, customer.id_card as customerIdCard, customer.name as customerName,\n" +
                    "            customer.phone_number as customerPhoneNumber, concat(section.name, location.name) as locationName,\n" +
                    "            floor.name as floorName, ticket.effective_date as ticketEffectiveDate, ticket.expiry_date as ticketExpiryDate\n" +
                    "            from\n" +
                    "            car\n" +
                    "            join customer on car.customer_id = customer.id\n" +
                    "            join car_type on car.car_type_id = car_type.id\n" +
                    "            join ticket on ticket.car_id = car.id\n" +
                    "            join location on location.id = ticket.location_id\n" +
                    "            join floor on location.floor_id = floor.id\n" +
                    "            join section on location.section_id = section.id\n" +
                    "            where car.plate_number like :carPlateNumber and customer.name like :customerName and customer.phone_number like :customerPhoneNumber and ticket.expiry_date >= now();", nativeQuery = true)
    List<ICarInOutDTO> searchCarInDTOByCustomerNameByPhoneNumberByPlateNumber(@Param("carPlateNumber") String carPlateNumber,
                                                                              @Param("customerName") String customerName,
                                                                              @Param("customerPhoneNumber") String customerPhoneNumber);


    @Query(value = "select\n" +
            "            car_in_out.time_in as timeIn, car_in_out.id as carInOutId, car_in_out.url_car_in_image as urlCarInImage,\n" +
            "            car.id as carId, car.plate_number as carPlateNumber,\n" +
            "            car.name as carName, car.brand as carBrand,\n" +
            "            customer.id_card as customerIdCard,\n" +
            "            car_type.name as carTypeName, customer.name as customerName,\n" +
            "            customer.phone_number as customerPhoneNumber, concat(section.name, location.name) as locationName,\n" +
            "            floor.name as floorName, ticket.effective_date as ticketEffectiveDate, ticket.expiry_date as ticketExpiryDate\n" +
            "            from\n" +
            "            car\n" +
            "            join customer on car.customer_id = customer.id\n" +
            "            join car_type on car.car_type_id = car_type.id\n" +
            "            join ticket on ticket.car_id = car.id\n" +
            "            join location on location.id = ticket.location_id\n" +
            "            join floor on location.floor_id = floor.id\n" +
            "            join section on location.section_id = section.id\n" +
            "            join car_in_out on car_in_out.car_id = car.id\n" +
            "            where car.plate_number like :carPlateNumber and customer.name like :customerName and customer.phone_number like :customerPhoneNumber and ticket.expiry_date >= now()\n" +
            "            and car_in_out.is_parked = true;", nativeQuery = true)
    List<ICarInOutDTO> searchCarOutDTOByCustomerNameByPhoneNumberByPlateNumber(@Param("carPlateNumber") String carPlateNumber,
                                                                               @Param("customerName") String customerName,
                                                                               @Param("customerPhoneNumber") String customerPhoneNumber);
}
