package com.example.repository.ticket;

import com.example.dto.ITicketDto;
import com.example.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
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


    @Query(value = "SELECT COUNT(ticket.id) " +
            "FROM car " +
            "JOIN ticket ON car.id = ticket.car_id " +
            "WHERE MONTH(ticket.effective_date) >= :sinceMonth " +
            "  AND MONTH(ticket.expiry_date) <= :toMonth " +
            "  AND YEAR(ticket.effective_date) = YEAR(ticket.expiry_date)", nativeQuery = true)
    List<ITicketDto> statisticalChart(@Param("sinceMonth") int sinceMonth, @Param("toMonth") int toMonth);


    @Query(value = "SELECT DATEDIFF(:expiry_date, :effective_date ) * 15000 * :rate ", nativeQuery = true)
    Integer getPriceOfTicket(@Param("expiry_date") Date expiry_date
            , @Param("effective_date") Date effective_date,
                            @Param("rate") double rate);


    @Query(value = "SELECT DISTINCT MONTH(expiry_date) AS month FROM ticket WHERE MONTH(expiry_date) BETWEEN :sinceMonth AND :toMonth ORDER BY month ASC",nativeQuery = true)
    List<ITicketDto> displayMonth(@Param("sinceMonth") int sinceMonth,@Param("toMonth") int toMonth);
}
