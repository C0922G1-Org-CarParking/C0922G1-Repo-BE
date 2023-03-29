package com.example.controller.ticket;

import com.example.dto.EditTicketDto;
import com.example.dto.TicketDto;
import com.example.model.Ticket;
import com.example.service.ticket.TicketService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/ticket")
@CrossOrigin("*")
public class TicketController {
    @Autowired
    private TicketService ticketService;

    @GetMapping("/ticket")
    private ResponseEntity<Ticket> findTicket(@RequestParam(value = "id", defaultValue = "-1") Long id) {
        Ticket ticket = ticketService.findTicket(id);
        if (ticket == null || id == null || id == -1) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(ticket, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    private ResponseEntity<?> updateTicket(@Validated @RequestBody EditTicketDto editTicketDto, BindingResult bindingResult) {
        new TicketDto().validate(editTicketDto, bindingResult);
        Ticket ticket = new Ticket();
        BeanUtils.copyProperties(editTicketDto, ticket);
//        ticketService.updateTicket1(editTicketDto.getLocationId(), editTicketDto.getExpiryDate(), editTicketDto.getId());
//        ticketService.updateTicket2(editTicketDto.getFloorId(), editTicketDto.getSectionId(), editTicketDto.getId());
        ticketService.updateTicket(ticket.getTicketType().getId(), ticket.getLocation().getFloor().getId(), ticket.getLocation().getSection().getId(), ticket.getExpiryDate(), ticket.getId());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
