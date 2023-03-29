package com.example.service.ticket;

import com.example.dto.TicketDto;
import com.example.model.Ticket;
import com.example.repository.ticket.ITicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class TicketService implements ITicketService {
    @Autowired
    private ITicketRepository ticketRepository;

    @Override
    public Ticket findTicket(Long id) {
        return ticketRepository.findTicket(id);
    }

    @Override
    public void updateTicket(Long ticketTypeId, Long floorId, Long sectionId, String expiryDate, Long id) {
        ticketRepository.updateTicket(ticketTypeId, floorId, sectionId, expiryDate, id);
    }
}
