package com.example.service.ticket;

import com.example.dto.ITicketDto;
import com.example.model.*;

import java.util.List;

public interface ITicketService {

    void addTicket(String effectiveDate, String expiryDate, boolean deleted, double totalPrice, Long id, Long id1, Long id2, Long id3);

    List<ITicketDto> statisticalChart(int sinceMonth, int toMonth);
}
