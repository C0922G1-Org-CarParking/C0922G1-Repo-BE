package com.example.service;

import com.example.model.TicketType;
import com.example.repository.ITicketTypeRepository;
import com.example.repository.ticket.ITicketRepository;
import com.example.service.impl.ITicketTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketTypeService implements ITicketTypeService {
    @Autowired
    private ITicketTypeRepository iTicketTypeRepository;

    @Override
    public List<TicketType> getAllTicketType() {
        return iTicketTypeRepository.getAllTicketType();
    }
}
