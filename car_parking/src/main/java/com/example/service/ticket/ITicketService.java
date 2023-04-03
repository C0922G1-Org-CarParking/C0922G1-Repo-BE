package com.example.service.ticket;

import com.example.dto.EditTicketDto;
import com.example.dto.ITicketDto;
import com.example.model.Ticket;

public interface ITicketService {
    ITicketDto findTicket(Long id);
    void updateTicket(Long ticketTypeId,Long floorId, Long sectionId,String expiryDate,Long id);
}
