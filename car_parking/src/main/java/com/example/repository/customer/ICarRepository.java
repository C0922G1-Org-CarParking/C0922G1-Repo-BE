package com.example.repository.customer;

import com.example.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface ICarRepository extends JpaRepository<Car, Integer> {
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
