package com.example.service.ticket;

import com.example.dto.TicketDto;
import com.example.model.Ticket;
import com.example.repository.ticket.ITicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class TicketService implements ITicketService {
    @Autowired
    private ITicketRepository ticketRepository;

    @Override
    public Ticket findTicket(Long id) {
        return ticketRepository.findTicket(id);
    }

    @Override
    public void updateTicket1(Long locationId, String expiryDate, Long id) {

    }

    @Override
    public void updateTicket2(Long floorId, Long sectionId, Long id) {

    }
//
//    @Override
//    public void updateTicket1(Long locationId, String expiryDate, Long id) {
//        ticketRepository.updateTicket1(locationId, expiryDate, id);
//    }
//
//    @Override
//    public void updateTicket2(Long floorId, Long sectionId, Long id) {
//        ticketRepository.updateTicket2(floorId, sectionId, id);
//    }

    @Override
    public void updateTicket(Long ticketTypeId, Long floorId, Long sectionId, String expiryDate, Long id) {
        ticketRepository.updateTicket(ticketTypeId, floorId, sectionId, expiryDate, id);
    }


//    @Override
//    public Map<String, String> checkUpdate(TicketDto ticketDto) {
//        Map<String, String> checkMap = new HashMap<>();
//
//        Ticket ticket = findTicket(ticketDto.getId());
//
//        for (int i = 0; i < ticketRepository.supplierList().size(); i++) {
//            if (!supplier.getPhoneNumber().equals(supplierDto.getPhoneNumber()) && supplierRepository.supplierList().get(i).getPhoneNumber().equals(supplierDto.getPhoneNumber())) {
//                checkMap.put("errorPhone", "Số điện thoại đã tồn tại trong hệ thống.");
//            }
//            if (!supplier.getEmail().equals(supplierDto.getEmail()) && supplierRepository.supplierList().get(i).getEmail().equals(supplierDto.getEmail())) {
//                checkMap.put("errorEmail", "Email đã tồn tại trong hệ thống.");
//            }
//        }
//        return checkMap;
//    }

}
