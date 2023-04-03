package com.example.repository;

import com.example.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface ITicketRepository extends JpaRepository<Ticket, Integer> {
    /**
     * Create by: VuBD
     * Date create: 30/03/2023
     * Function: connect database to get data a ticket with corresponding id
     * @param carId
     * @return
     */
    @Query(value = "SELECT * FROM c0922g1_car_parking.ticket where car_id = :carId " +
            "and is_deleted = 0 " +
            "and expiry_date >= CURRENT_DATE()", nativeQuery = true)
    Ticket findTicketByCarId(@Param("carId") int carId);

    /**
     * Create by: VuBD
     * Date create: 03/04/2023
     * Function: connect database to delete a ticket with corresponding id
     * @param carId
     */
    @Transactional
    @Modifying
    @Query(value = "UPDATE c0922g1_car_parking.ticket SET is_deleted = 1  WHERE car_id = :carId", nativeQuery = true)
    void deleteTicketByCarId(@Param("carId") int carId);
}