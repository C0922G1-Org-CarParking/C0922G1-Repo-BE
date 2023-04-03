package com.example.service;

import com.example.dto.TicketOfListDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ITicketService {
    Page<TicketOfListDto> searchTicketList(String customerName,
                                           String customerPhone,
                                           String employeeName,
                                           String employeePhone,
                                           String floor,
                                           String expiryDate,
                                           String ticketType,
                                           int status,
                                           Pageable pageable);
    Page<TicketOfListDto> searchTicketExpired(String customerName,
                                              String customerPhone,
                                              String employeeName,
                                              String employeePhone,
                                              String floor,
                                              String ticketType,
                                              Pageable pageable);
    boolean delete(int idDelete);
    TicketOfListDto findTicketDetailById(int id);
}
