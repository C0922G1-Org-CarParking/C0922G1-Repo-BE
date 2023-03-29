package com.example.service.ticket;

import com.example.model.Ticket;

public interface ITicketService {
    Ticket findTicket(Long id);
    void updateTicket(Long ticketTypeId,Long floorId, Long sectionId,String expiryDate,Long id);
}
