package com.example.service.ticket;

import com.example.model.Ticket;

public interface ITicketService {
    Ticket findTicket(Long id);

    void updateTicket1(Long locationId, String expiryDate,Long id);
    void updateTicket2(Long floorId, Long sectionId,Long id);
    void updateTicket(Long ticketTypeId,Long floorId, Long sectionId,String expiryDate,Long id);
}
