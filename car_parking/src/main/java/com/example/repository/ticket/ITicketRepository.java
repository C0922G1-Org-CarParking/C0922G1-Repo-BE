package com.example.repository.ticket;

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
    @Query(value = "select * from ticket where id = :id and is_deleted = false", nativeQuery = true)
    Ticket findTicket(@Param("id") Long id);

    @Modifying
    @Query(value = "update ticket " +
            "join ticket_type tt on tt.id = ticket.ticket_type_id " +
            "join location l on l.id = ticket.location_id " +
            "join section s on s.id = l.section_id " +
            "join floor f on f.id = l.floor_id " +
            "set " +
            "ticket.ticket_type_id = :ticketTypeId," +
            "l.floor_id = :floorId," +
            "l.section_id = :sectionId," +
            "ticket.expiry_date = :expiryDate " +
            "where ticket.id = :id and ticket.is_deleted = false", nativeQuery = true)
    void updateTicket(@Param("ticketTypeId") Long ticketTypeId, @Param("floorId") Long floorId, @Param("sectionId") Long sectionId, @Param("expiryDate") String expiryDate, @Param("id") Long id);

}
