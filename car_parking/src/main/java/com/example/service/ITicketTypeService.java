package com.example.service;

import com.example.dto.ITicketTypeDTO;
import com.example.model.TicketType;

import java.util.List;

public interface ITicketTypeService {
    List<ITicketTypeDTO> getAllTicketTypes();

    List<TicketType> findAll();
}
