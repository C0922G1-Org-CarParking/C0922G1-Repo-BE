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
    @Query(value = "INSERT INTO `c0922g1_car_parking`.`ticket` (`effective_date`, `expiry_date`, `is_deleted`, `total_price`, `car_id`, `employee_id`, `location_id`, `ticket_type_id`,`price`)" +
            " VALUES (:effectiveDate, :expiryDate, :isDeleted,:totalPrice, :carId, :employeeId, :locationId,:ticketTypeId,:price )", nativeQuery = true)
    void addTicket(@Param("effectiveDate") String effectiveDate,
                   @Param("expiryDate") String expiryDate,
                   @Param("isDeleted") boolean isDeleted,
                   @Param("totalPrice") double totalPrice,
                   @Param("carId") Long carId, @Param("employeeId") Long employeeId,
                   @Param("locationId") Long locationId,
                   @Param("ticketTypeId") Long ticketTypeId,
                   @Param("price") Double price);


    @Query(value = "select count(ticket.id) from car join ticket on car.id = ticket.car_id" +
            " where (month(ticket.effective_date) =:sinceMonth) <= (month(ticket.expiry_date =:toMonth) ", nativeQuery = true)
    List<ITicketDto> statisticalChart(@Param("sinceMonth") int sinceMonth, @Param("toMonth") int toMonth);


    @Query(value = "SELECT DATEDIFF(day, ticket.effective_date, ticket.expiry_date) * ticket.price * car_type.rate " +
            "from ticket join car on  ticket.car_id = car.id join car.car_type_id = car_type.id;", nativeQuery = true)
    Ticket getPriceOfTicket();
}
