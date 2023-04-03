package com.example.service.impl;

import com.example.dto.TicketOfListDto;
import com.example.repository.ITicketRepository;
import com.example.service.ITicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TicketService implements ITicketService {

    @Autowired
    private ITicketRepository ticketRepository;
    @Override
    public Page<TicketOfListDto> search(String customerName, String customerPhone, String employeeName, String employeePhone, String floor, String expiryDate, String ticketType, int status, Pageable pageable) {
        return ticketRepository.search(customerName, customerPhone, employeeName, employeePhone, floor, expiryDate, ticketType, status, pageable);
    }

    @Override
    public Page<TicketOfListDto> searchTicketExpired(String customerName, String customerPhone, String employeeName, String employeePhone, String floor, String ticketType, Pageable pageable) {
        return ticketRepository.searchTicketExpired(customerName, customerPhone, employeeName, employeePhone, floor, ticketType, pageable);
    }

    @Override
    public boolean delete(int idDelete) {
        try {
            ticketRepository.delete(idDelete);
            return true;
        } catch (Exception e) {
            System.out.println("Lỗi");
            return false;
        }
    }

    @Override
    public TicketOfListDto findById(int id) {
        return ticketRepository.findById(id);
    }
}
