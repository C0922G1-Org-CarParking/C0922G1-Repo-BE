package com.example.service;

import com.example.dto.ITicketDto;
import com.example.dto.TicketOfListDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ITicketService {
    ITicketDto findTicket(Long id);

    void updateTicket(Long ticketTypeId, Long floorId, Long sectionId, String expiryDate, Long id);

    void addTicket(String effectiveDate, String expiryDate, boolean deleted, double totalPrice, Long id, Long id1, Long id2, Long id3, Double price);

    List<ITicketDto> statisticalChart(int sinceMonth, int toMonth);

    Double getPriceOfTicket(String expiryDate, String effectiveDate, double rate);

    List<ITicketDto> displayMonth(int sinceMonth, int toMonth);

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

    TicketOfListDto findById(int id);
}