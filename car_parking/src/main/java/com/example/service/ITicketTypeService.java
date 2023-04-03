package com.example.service;

import com.example.dto.ITicketTypeDto;
import com.example.model.TicketType;

import java.util.List;

public interface ITicketTypeService {
    List<ITicketTypeDto> getAllTicketTypes();

    List<TicketType> findAll();
}
