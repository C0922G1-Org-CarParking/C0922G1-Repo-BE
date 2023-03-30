package com.example.repository.customer_car;

import com.example.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ICarRepository extends JpaRepository<Car, Long> {
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

}
