package com.example.repository;

import com.example.dto.ICarOfTicketDTO;
import com.example.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface ICarRepository extends JpaRepository<Car, Long> {

    /**
     * Created by: MinhCDK
     * Date created: 29/03/2023
     * Function: createCar
     */

    @Modifying
    @Query(value = "insert into car (brand, is_deleted, name, plate_number, car_type_id, customer_id,is_parked)value(:brand, " +
            "false, :name, :plateNumber, :carTypeId, :customerId, 0)", nativeQuery = true)
    void createCar(@Param("brand") String brand,
                   @Param("name") String name,
                   @Param("plateNumber") String plateNumber,
                   @Param("carTypeId") Long carTypeId,
                   @Param("customerId") Long customerId);



    /**
     * Created by: MinhCDK
     * Date created: 29/03/2023
     * Function: infoCar
     *
     * @Param: customerId
     * Return: infoCustomer and listCar
     * @return
     */


    @Modifying
    @Query(value = "select car.id as carId, ct.name as carTypeName, car.name as carName, car.plate_number as plateNumber, tt.name as ticketTypeName, t.expiry_date as expiryDate, f.name as floorName, s.name as sectionName, l.name as locationName from car join customer c on c.id = car.customer_id join ticket t on car.id = t.car_id join location l on l.id = t.location_id join car_type ct on ct.id = car.car_type_id join ticket_type tt on tt.id = t.ticket_type_id join floor f on l.floor_id = f.id join section s on l.section_id = s.id where c.id = :id and c.is_deleted = false and car.is_deleted = false and t.is_deleted = false", nativeQuery = true)
    List<ICarOfTicketDTO> findCarTicketByCustomerId(@Param("id") Long id);

    /**
     * Create by: VuTN,
     * Date create : 29/03/2023
     * Function : connect database to delete car  with corresponding id
     *
     * @Param id
     */
    @Modifying
    @Transactional
    @Query(value = "update car set  car.is_deleted = true where car.plate_number=:plate_number", nativeQuery = true)
    void deleteCarById(@Param("plate_number") String plate_number);

    /**
     * Create by: VuTN,
     * Date create : 29/03/2023
     * Function : connect database to find  car list with corresponding id of customer
     *
     * @Param id
     */

    @Modifying
    @Transactional
    @Query(value = "select * from car where car.customer_id = :id and is_deleted =false", nativeQuery = true)
    List<Car> findByCarId(@Param("id") Long id);

    /**
     * Create by: VuTN,
     * Date create : 29/03/2023
     * Function : connect database to save  car  with corresponding id of customer
     *
     * @Param("name") String name,
     * @Param("car_type_id") Long car_type_id,
     * @Param("brand")String brand,
     * @Param("plate_number") String plate_number,
     * @Param("customer_id") Long customer_id
     */
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO car(`name`,car_type_id,brand,plate_number,is_deleted,customer_id)" +
            "VALUES (:name,:car_type_id,:brand,:plate_number,false,:customer_id)", nativeQuery = true)
    void createCar(@Param("name") String name, @Param("car_type_id") Long car_type_id, @Param("brand") String brand, @Param("plate_number") String plate_number,
                   @Param("customer_id") Long customer_id);
 @Query(value = "select * from car where car.id=:id", nativeQuery = true)
    List<Car> carList (Long id);
    /**
     * Create by: VuBD
     * Date create: 30/03/2023
     * Function: connect database to get data a car with corresponding id
     *
     * @param customerId
     */
    @Query(value = "SELECT car.id FROM c0922g1_car_parking.car where is_deleted = 0 AND customer_id = :customerId", nativeQuery = true)
    int[] findCarByCustomerId(@Param("customerId") int customerId);

    /**
     * Create by: VuBD
     * Date create: 29/03/2023
     * Function: connect database to delete a car with corresponding id
     *
     * @param customerId
     */
    @Transactional
    @Modifying
    @Query(value = "UPDATE c0922g1_car_parking.car SET is_deleted = 1 WHERE is_deleted = 0 AND customer_id = :customerId", nativeQuery = true)
    void deleteCarByCustomerId(@Param("customerId") int customerId);
}
