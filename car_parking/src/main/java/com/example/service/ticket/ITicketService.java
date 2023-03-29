package com.example.service.ticket;

import com.example.model.Car;
import com.example.model.Employee;
import com.example.model.Location;
import com.example.model.TicketType;

public interface ITicketService {

    void addTicket(String effectiveDate, String expiryDate, boolean deleted, double totalPrice, Long id, Long id1, Long id2, Long id3);
}
