package com.example.service.impl;

import com.example.dto.ITicketTypeDTO;
import com.example.model.TicketType;
import com.example.repository.ITicketTypeRepository;
import com.example.service.ITicketTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketTypeService implements ITicketTypeService {
    @Autowired
    private ITicketTypeRepository iTicketTypeRepository;

    @Override
    public List<ITicketTypeDTO> getAllTicketTypes() {
        return iTicketTypeRepository.getListNameTicketType();
    }

    @Override
    public List<TicketType> findAll() {
        return iTicketTypeRepository.findAll();
    }
}
