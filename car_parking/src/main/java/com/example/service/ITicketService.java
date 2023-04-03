package com.example.service;

import com.example.dto.EditTicketDto;
import com.example.dto.ITicketDto;
import com.example.model.Ticket;
import com.example.dto.ITicketDto;
import com.example.model.*;

import java.util.List;

public interface ITicketService {
    ITicketDto findTicket(Long id);

    void updateTicket(Long ticketTypeId, Long floorId, Long sectionId, String expiryDate, Long id);

    void addTicket(String effectiveDate, String expiryDate, boolean deleted, double totalPrice, Long id, Long id1, Long id2, Long id3, Double price);

    List<ITicketDto> statisticalChart(int sinceMonth, int toMonth);

    Integer getPriceOfTicket(String expiryDate, String effectiveDate, double rate);

    List<ITicketDto> displayMonth(int sinceMonth, int toMonth);
}
