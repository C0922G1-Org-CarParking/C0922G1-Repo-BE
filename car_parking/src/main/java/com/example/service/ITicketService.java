package com.example.service;

import com.example.dto.ITicketDTO;
import com.example.dto.TicketOfListDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ITicketService {
    ITicketDTO findTicket(Long id);

    void updateTicket(Long ticketTypeId, Long floorId, Long sectionId, String expiryDate, Long id);

    void addTicket(String effectiveDate, String expiryDate, boolean deleted, double totalPrice, Long id, Long id1, Long id2, Long id3, Double price);

    List<ITicketDTO> statisticalChart(int sinceMonth, int toMonth);

    Integer getPriceOfTicket(String expiryDate, String effectiveDate, double rate);

    List<ITicketDTO> displayMonth(int sinceMonth, int toMonth);

    Page<TicketOfListDTO> searchTicketList(String customerName,
                                           String customerPhone,
                                           String employeeName,
                                           String employeePhone,
                                           String floor,
                                           String expiryDate,
                                           String ticketType,
                                           int status,
                                           Pageable pageable);


    Page<TicketOfListDTO> searchTicketExpired(String customerName,
                                              String customerPhone,
                                              String employeeName,
                                              String employeePhone,
                                              String floor,
                                              String ticketType,
                                              Pageable pageable);

    boolean delete(int idDelete);

    TicketOfListDTO findTicketDetailById(int id);

    TicketOfListDTO findById(int id);

    Integer[] getValue(int sinceMonth, int toMonth, int year);

    Integer[] getTicketList(int sinceMonth, int toMonth, int year);

}
