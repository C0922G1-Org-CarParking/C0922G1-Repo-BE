package com.example.service;

import com.example.dto.TicketDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ITicketService {
    Page<TicketDto> search(String customerName,
                        String customerPhone,
                        String employeeName,
                        String employeePhone,
                        String floor,
                        String expiryDate,
                        String ticketType,
                        Pageable pageable);
    boolean delete(int idDelete);
    TicketDto findById(int id);
}
