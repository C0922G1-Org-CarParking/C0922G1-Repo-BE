package com.example.repository;

import com.example.dto.EditTicketDto;
import com.example.dto.ITicketDto;
import com.example.model.Ticket;
import com.example.dto.ITicketDto;
import com.example.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Transactional;
import java.sql.Date;
import java.util.List;

@Repository
@Transactional
public interface ITicketRepository extends JpaRepository<Ticket, Long> {

    /**
     * Created by: HuyNL
     * Date created: 29/03/2023
     * Function: editTicket and
     */

    @Query(value = "select \n" +
            "ticket.id as ticketId, ct.rate as rate, c.name as customerName, c2.plate_number as plateNumber,c.phone_number as phoneNumber,\n" +
            "ticket.effective_date as effectiveDate, ticket.expiry_date as expiryDate, f.id as floorId,l.id as locationId, \n" +
            "s.id as sectionId, ticket.total_price as totalPrice, tt.id as ticketTypeId \n" +
            "from ticket \n" +
            "join car c2 on c2.id = ticket.car_id \n" +
            "join car_type ct on ct.id = c2.car_type_id \n" +
            "join customer c on c.id = c2.customer_id join location l on l.id = ticket.location_id \n" +
            "join section s on s.id = l.section_id join floor f on f.id = l.floor_id \n" +
            "join ticket_type tt on tt.id = ticket.ticket_type_id where ticket.id = 1 and ticket.is_deleted = false", nativeQuery = true)
    ITicketDto findTicket(@Param("id") Long id);

    /**
     * Created by: HuyNL
     * Date created: 29/03/2023
     * Function: editTicket and
     */
    @Modifying
    @Query(value = "update ticket join location l on l.id = ticket.location_id set l.floor_id= :floorId,l.section_id= :sectionId, ticket.ticket_type_id= :ticketTypeId, ticket.expiry_date = :expiryDate where ticket.id =:id and ticket.is_deleted = false", nativeQuery = true)
    void updateTicket(@Param("ticketTypeId") Long ticketTypeId, @Param("floorId") Long floorId, @Param("sectionId") Long sectionId, @Param("expiryDate") String expiryDate, @Param("id") Long id);



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
