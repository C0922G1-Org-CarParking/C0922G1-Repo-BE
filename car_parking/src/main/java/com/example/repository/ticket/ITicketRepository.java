package com.example.repository.ticket;

import com.example.dto.EditTicketDto;
import com.example.dto.ITicketDto;
import com.example.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
}
