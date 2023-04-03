package com.example.controller.ticket;

import com.example.dto.EditTicketDto;
import com.example.dto.ITicketDto;
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
@RequestMapping("/api")
@CrossOrigin("*")
public class TicketRestController {
    @Autowired
    private TicketService ticketService;

    /**
     * Created by: HuyNL
     * Date created: 29/03/2023
     * Function: edit Ticket
     * @return HttpStatus.No_Content if result is null or HttpStatus.OK is result is not error
     */
    @GetMapping("/ticket/{id}")
    private ResponseEntity<ITicketDto> findTicket(@PathVariable("id") Long id) {
        ITicketDto editTicketDto = ticketService.findTicket(id);
        if (editTicketDto == null || id == null || id == -1) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(editTicketDto, HttpStatus.OK);
    }

    @PutMapping("/ticket/update/{id}")
    private ResponseEntity<?> updateTicket(@Validated @RequestBody EditTicketDto editTicketDto,
                                           BindingResult bindingResult) {
       if (bindingResult.hasErrors()){
           return new ResponseEntity<>(bindingResult.getAllErrors(),HttpStatus.BAD_REQUEST);
       }
        ticketService.updateTicket(
                editTicketDto.getTicketTypeId(),
                editTicketDto.getFloorId(),
                editTicketDto.getSectionId(),
                editTicketDto.getExpiryDate(),
                editTicketDto.getId()
        );
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
