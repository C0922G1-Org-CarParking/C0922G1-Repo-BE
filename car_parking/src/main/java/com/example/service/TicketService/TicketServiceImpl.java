package com.example.service.TicketService;

import com.example.dto.TicketDto;
import com.example.repository.ticket.ITicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TicketServiceImpl implements ITicketService{

    @Autowired
    private ITicketRepository ticketRepository;
    @Override
    public Page<TicketDto> search(String customerName, String customerPhone, String employeeName, String employeePhone, String floor, String expiryDate, String ticketType, Pageable pageable) {
        return ticketRepository.search(customerName, customerPhone, employeeName, employeePhone, floor, expiryDate, ticketType, pageable);
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
    public TicketDto findById(int id) {
        return ticketRepository.findById(id);
    }
}
