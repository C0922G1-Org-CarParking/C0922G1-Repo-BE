package com.example.controller.ticket;

import com.example.dto.TicketDto;
import com.example.service.TicketService.ITicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/ticket")
public class TicketRestController {

    @Autowired
    private ITicketService ticketService;
    /**
    * Created by: NhanPT
    * Date create: 29/02/2023
    * Function: searchTicket
    *
    * @param: customerName,
    *         customerPhone,
    *         employeeName,
    *         employeePhone,
    *         floor,
    *         expiryDate,
    *         ticketType,
    *         page,
    *         size
    * @return: HttpStatus.NO_CONTENT when not has content or Page<Ticket> and HttpStatus.Ok when has content
    */

    @GetMapping("/search")
    public ResponseEntity<Page<TicketDto>> searchTicket(@RequestParam(value = "customerName", defaultValue = "")String customerName,
                                               @RequestParam(value = "customerPhone", defaultValue = "")String customerPhone,
                                               @RequestParam(value = "employeeName", defaultValue = "")String employeeName,
                                               @RequestParam(value = "employeePhone", defaultValue = "")String employeePhone,
                                               @RequestParam(value = "floor", defaultValue = "")String floor,
                                               @RequestParam(value = "expiryDate", defaultValue = "")String expiryDate,
                                               @RequestParam(value = "ticketType", defaultValue = "")String ticketType,
                                               @RequestParam(value = "page", defaultValue = "0")int page,
                                               @RequestParam(value = "size", defaultValue = "4")int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<TicketDto> ticketPage = ticketService.search(customerName, customerPhone, employeeName, employeePhone, floor, expiryDate, ticketType, pageable);
        if (!ticketPage.hasContent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(ticketPage, HttpStatus.OK);
        }
    }
    /**
     * Created by: NhanPT
     * Date create: 29/02/2023
     * Function: detailTicket
     *
     * @param: id
     * @return: HttpStatus.NO_CONTENT when result null or Ticket and HttpStatus.Ok when result not null
     */

    @GetMapping("detail/{id}")
    public ResponseEntity<TicketDto> detailTicket(@PathVariable("id") int id) {
        TicketDto ticket = ticketService.findById(id);
        if (ticket == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(ticket, HttpStatus.OK);
        }
    }
    /**
     * Created by: NhanPT
     * Date create: 29/02/2023
     * Function: deleteTicket
     *
     * @param: id
     * @return: HttpStatus.INTERNAL_SERVER_ERROR when exception occurs or Ticket and HttpStatus.Ok when delete success
     */

    @DeleteMapping("delete/{idDelete}")
    public ResponseEntity<Boolean> deleteTicket(@PathVariable("idDelete") int idDelete) {
        if (ticketService.delete(idDelete)) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

