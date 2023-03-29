package com.example.service.ticket_type;

import com.example.dto.ITicketTypeDto;
import com.example.repository.ticket_type.ITicketTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketTypeService implements ITicketTypeService{
    @Autowired
    private ITicketTypeRepository iTicketTypeRepository;
    @Override
    public List<ITicketTypeDto> getListNameTicketType() {
        return iTicketTypeRepository.getListNameTicketType();
    }
}
