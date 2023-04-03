package com.example.controller;

import com.example.dto.TicketOfListDto;
import com.example.model.Floor;
import com.example.model.TicketType;
import com.example.service.IFloorService;
import com.example.service.ITicketService;
import com.example.service.ITicketTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/ticket")
public class TicketRestController {

    @Autowired
    private ITicketService ticketService;
    @Autowired
    private ITicketTypeService ticketTypeService;
    @Autowired
    private IFloorService floorService;

    /**
     * Created by: NhanPT
     * Date create: 29/02/2023
     * Function: searchTicket
     *
     * @param: customerName,
     * customerPhone,
     * employeeName,
     * employeePhone,
     * floor,
     * expiryDate,
     * ticketType,
     * status,
     * page,
     * size
     * @return: HttpStatus.NO_CONTENT when not has content or Page<Ticket> and HttpStatus.Ok when has content
     */

    @GetMapping("/search")
    public ResponseEntity<Page<TicketOfListDto>> searchTicket(@RequestParam(value = "customerName", defaultValue = "") String customerName,
                                                              @RequestParam(value = "customerPhone", defaultValue = "") String customerPhone,
                                                              @RequestParam(value = "employeeName", defaultValue = "") String employeeName,
                                                              @RequestParam(value = "employeePhone", defaultValue = "") String employeePhone,
                                                              @RequestParam(value = "floor", defaultValue = "") String floor,
                                                              @RequestParam(value = "expiryDate", defaultValue = "") String expiryDate,
                                                              @RequestParam(value = "ticketType", defaultValue = "") String ticketType,
                                                              @RequestParam(value = "status", defaultValue = "0") int status,
                                                              @RequestParam(value = "page", defaultValue = "0") int page,
                                                              @RequestParam(value = "size", defaultValue = "5") int size) {
        Sort sort = Sort.by(Sort.Direction.ASC, "TicketId");

        Pageable pageable = PageRequest.of(page, size, sort);
        Page<TicketOfListDto> ticketPage;
        if (status == 3) {
            ticketPage = ticketService.searchTicketExpired(customerName, customerPhone, employeeName, employeePhone, floor, ticketType, pageable);
        } else {
            ticketPage = ticketService.search(customerName, customerPhone, employeeName, employeePhone, floor, expiryDate, ticketType, status, pageable);
        }
        if (!ticketPage.hasContent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(ticketPage, HttpStatus.OK);
        }
    }

    /**
     * Created by: NhanPT
     * Date create: 29/02/2023
     * Function: findAllFloor
     *
     * @param: not parameter
     *
     * @return: HttpStatus.NO_CONTENT when not has content or List<Floor> and HttpStatus.Ok when has content
     */

    @GetMapping("/floor")
    public ResponseEntity<List<Floor>> findAllFloor() {
        List<Floor> floorList = floorService.findAll();
        if (floorList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(floorList, HttpStatus.OK);
        }
    }

    /**
     * Created by: NhanPT
     * Date create: 29/02/2023
     * Function: findAllTicketType
     *
     * @param: no parameter
     * @return: HttpStatus.NO_CONTENT when not has content or List<Floor> and HttpStatus.Ok when has content
     */

    @GetMapping("/ticketType")
    public ResponseEntity<List<TicketType>> findAllTicketType() {
        List<TicketType> ticketTypeList = ticketTypeService.findAll();
        if (ticketTypeList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(ticketTypeList, HttpStatus.OK);
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
    public ResponseEntity<TicketOfListDto> detailTicket(@PathVariable("id") int id) {
        TicketOfListDto ticket = ticketService.findById(id);
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

