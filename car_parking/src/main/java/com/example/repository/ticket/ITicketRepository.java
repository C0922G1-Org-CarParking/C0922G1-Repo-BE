package com.example.repository.ticket;

import com.example.dto.ITicketDto;
import com.example.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface ITicketRepository extends JpaRepository<Ticket, Long> {
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO `c0922g1_car_parking`.`ticket` (`effective_date`, `expiry_date`, `is_deleted`, `total_price`, `car_id`, `employee_id`, `location_id`, `ticket_type_id`)" +
            " VALUES (:effectiveDate, :expiryDate, :isDeleted,:totalPrice, :carId, :employeeId, :locationId,:ticketTypeId )", nativeQuery = true)
    void addTicket(@Param("effectiveDate") String effectiveDate,
                   @Param("expiryDate") String expiryDate,
                   @Param("isDeleted") boolean isDeleted,
                   @Param("totalPrice") double totalPrice,
                   @Param("carId") Long carId, @Param("employeeId") Long employeeId,
                   @Param("locationId") Long locationId,
                   @Param("ticketTypeId") Long ticketTypeId);


    @Query(value = "select count(ticket.id) from car join ticket on car.id = ticket.car_id" +
            " where (month(ticket.effective_date) =:sinceMonth) < (month(ticket.expiry_date =:toMonth) ", nativeQuery = true)
    List<ITicketDto> statisticalChart(@Param("sinceMonth") int sinceMonth, int toMonth);


}
