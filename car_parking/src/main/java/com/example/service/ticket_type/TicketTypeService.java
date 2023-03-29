package com.example.service.ticket_type;

import com.example.repository.ticket_type.ITicketTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class TicketTypeService implements ITicketTypeService{
    @Autowired
    private ITicketTypeRepository iTicketTypeRepository;
    @Override
    public void getListNameTicketType() {
        iTicketTypeRepository.getListNameTicketType();
    }
}
