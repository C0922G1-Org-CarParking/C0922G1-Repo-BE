package com.example.repository;

import com.example.dto.ICarInOutDTO;
import com.example.model.CarInOut;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface ICarInOutRepository extends JpaRepository<CarInOut, Long> {
    @Query(value = "select\n" +
            "car.id as carId, car.plate_number as carPlateNumber, \t\t\n" +
            "car.name as carName, car.brand as carBrand,     \t\t\n" +
            "car_type.name as carTypeName, customer.name as customerName,\t\t\n" +
            "customer.phone_number as customerPhoneNumber, concat(section.name, location.name) as locationName, \t\t\n" +
            "floor.name as floorName, ticket.effective_date as ticketEffectiveDate, ticket.expiry_date as ticketExpiryDate\t\t\n" +
            "from\t\t\n" +
            "car \t\t\n" +
            "join customer on car.customer_id = customer.id\t\t\n" +
            "join car_type on car.car_type_id = car_type.id\t\t\n" +
            "join ticket on ticket.car_id = car.id\t\t\n" +
            "join location on location.id = ticket.location_id\t\t\n" +
            "join floor on location.floor_id = floor.id\t\t\n" +
            "join section on location.section_id = section.id\t\t\n" +
            "where car.plate_number = :plateNumber and ticket.expiry_date >= now();", nativeQuery = true)
    ICarInOutDTO searchCarInDTOByScanning(@Param("plateNumber") String plateNumber);


    @Query(value = "select\n" +
            "car_in_out.id as carInOutId, car_in_out.time_in as timeIn,\n" +
            "car.id as carId, car_in_out.url_car_in_image as urlCarInImage," +
            "car_in_out.url_car_out_image as urlCarOutImage, car.plate_number as carPlateNumber, \t\t\n" +
            "car.name as carName, car.brand as carBrand,     \t\t\n" +
            "car_type.name as carTypeName, customer.name as customerName,\t\t\n" +
            "customer.phone_number as customerPhoneNumber, concat(section.name, location.name) as locationName, \t\t\n" +
            "floor.name as floorName, ticket.effective_date as ticketEffectiveDate, ticket.expiry_date as ticketExpiryDate\t\t\n" +
            "from\t\t\n" +
            "car \t\t\n" +
            "join customer on car.customer_id = customer.id\t\t\n" +
            "join car_type on car.car_type_id = car_type.id\t\t\n" +
            "join ticket on ticket.car_id = car.id\t\t\n" +
            "join location on location.id = ticket.location_id\t\t\n" +
            "join floor on location.floor_id = floor.id\t\t\n" +
            "join section on location.section_id = section.id\n" +
            "join car_in_out on car_in_out.car_id = car.id\t\t\n" +
            "where car.plate_number = :plateNumber and car_in_out.is_parked = true " +
            "and ticket.expiry_date >= now()", nativeQuery = true)
    ICarInOutDTO searchCarOutDTOByScanning(@Param("plateNumber") String plateNumber);


    @Transactional
    @Query(value = "INSERT INTO `c0922g1_car_parking`.`car_in_out` (`is_parked`, `time_in`, `car_id`, `url_car_in_image`) VALUES (:isParked, :timeIn, :carId, :urlCarInImage);", nativeQuery = true)
    @Modifying
    void saveCarIn(@Param("carId") long carId,
                   @Param("timeIn") String timeIn,
                   @Param("isParked") boolean isParked,
                   @Param("urlCarInImage") String urlCarInImage);

    @Transactional
    @Query(value = "UPDATE `c0922g1_car_parking`.`car_in_out` SET `is_parked` = :isParked, `time_out` = :timeOut,`url_car_out_image` = :urlCarOutImage WHERE id = :id", nativeQuery = true)
    @Modifying
    void saveCarOut(@Param("timeOut") String timeOut, @Param("id") Long id, @Param("isParked") boolean isParked,
                    @Param("urlCarOutImage") String urlCarOutImage);

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
