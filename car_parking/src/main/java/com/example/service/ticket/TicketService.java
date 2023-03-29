package com.example.service.ticket;

import com.example.model.Car;
import com.example.model.Employee;
import com.example.model.Location;
import com.example.model.TicketType;
import com.example.repository.ticket.ITicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketService implements ITicketService{
    @Autowired
    private ITicketRepository iTicketRepository;

    @Override
    public void addTicket(String effectiveDate, String expiryDate, boolean deleted, double totalPrice, Long id, Long id1, Long id2, Long id3) {
        iTicketRepository.addTicket(effectiveDate,expiryDate,deleted,totalPrice,id,id1,id2,id3);
    }
}
