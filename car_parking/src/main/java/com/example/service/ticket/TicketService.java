package com.example.service.ticket;

import com.example.dto.ITicketDto;
import com.example.model.*;
import com.example.repository.ticket.ITicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService implements ITicketService{
    @Autowired
    private ITicketRepository iTicketRepository;

    @Override
    public void addTicket(String effectiveDate, String expiryDate, boolean deleted, double totalPrice, Long id, Long id1, Long id2, Long id3,double price) {
        iTicketRepository.addTicket(effectiveDate,expiryDate,deleted,totalPrice,id,id1,id2,id3,price);
    }

    @Override
    public List<ITicketDto> statisticalChart(int sinceMonth, int toMonth) {
        return iTicketRepository.statisticalChart(sinceMonth,toMonth);
    }

    @Override
    public Ticket getPriceOfTicket() {
        return iTicketRepository.getPriceOfTicket();
    }
}
