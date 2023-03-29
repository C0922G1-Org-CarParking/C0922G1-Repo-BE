package com.example.controller.ticket;

import com.example.dto.EmployeeDto;
import com.example.dto.ITicketDTO;
import com.example.dto.TicketDto;
import com.example.model.Employee;
import com.example.model.Location;
import com.example.model.Ticket;
import com.example.model.TicketType;
import com.example.service.employee.IEmployeeService;
import com.example.service.location.ILocationService;
import com.example.service.ticket.ITicketService;
import com.example.service.ticket_type.ITicketTypeService;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin("*")
@RequestMapping("/ticket")
public class TicketController {
    @Autowired
    private ITicketService iTicketService;
    @Autowired
    private ITicketTypeService iTicketTypeService;
    @Autowired
    private ILocationService iLocationService;
    @Autowired
    private IEmployeeService iEmployeeService;

    /**
     * Created by: HuyNV
     * Date created: 29/03/2023
     * Function: createTicket
     *
     * @param ticketDto, bindingResult
     * @return HttpStatus.BAD_REQUEST if result is null or HttpStatus.OK is result is not error
     */

    @PostMapping("/createTicket")
    public ResponseEntity<Ticket> createTicket(@Validated @RequestBody TicketDto ticketDto, BindingResult bindingResult) {
        new TicketDto().validate(ticketDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Ticket ticket = new Ticket();
        BeanUtils.copyProperties(ticketDto, ticket);
        iTicketService.addTicket(ticket.getEffectiveDate(), ticket.getExpiryDate(), ticket.isDeleted(),ticket.getTotalPrice(), ticket.getCar().getId(), ticket.getEmployee().getId(), ticket.getLocation().getId(),ticket.getTicketType().getId());
        ticket.getLocation().setOccupied(true);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Created by: HuyNV
     * Date created: 29/03/2023
     * Function: getListNameTicketType
     *
     * @param
     * @return  HttpStatus.OK is result is not error
     */
    @GetMapping("/listTicketType")
    public ResponseEntity<TicketType> getListNameTicketType() {
        iTicketTypeService.getListNameTicketType();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Created by: HuyNV
     * Date created: 29/03/2023
     * Function: getListLocation
     *
     * @param
     * @return  HttpStatus.OK is result is not error
     */

    @GetMapping("/listLocation")
    public ResponseEntity<Location> getListLocation() {
        iLocationService.getListNameLocation();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Created by: HuyNV
     * Date created: 29/03/2023
     * Function: getListFloor
     *
     * @param
     * @return  HttpStatus.OK is result is not error
     */

    @GetMapping("/listLocation")
    public ResponseEntity<Location> getListFloor() {
        iLocationService.getListNameFloor();
        return new ResponseEntity<>(HttpStatus.OK);
    }


    /**
     * Created by: HuyNV
     * Date created: 29/03/2023
     * Function: getListEmployee
     *
     * @param
     * @return HttpStatus.BAD_REQUEST if result is null or HttpStatus.OK is result is not error
     */
    @GetMapping("/listSearchEmployee")
    public ResponseEntity<Employee> getListEmployee(@RequestParam(defaultValue = "") String name) {
        List<Employee> employeeList = iEmployeeService.getListEmployeeByName(name);
        if (employeeList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }


    /**
     * Created by: HuyNV
     * Date created: 29/03/2023
     * Function: getNameChooseById
     *
     * @param
     * @return HttpStatus.OK is result is not error
     */
    @GetMapping("/choose/{id}")
    public ResponseEntity<?> getNameChooseById(@PathVariable("id") int id){
        EmployeeDto employeeDto = iEmployeeService.findEmployeeId(id);
        Employee employee = new Employee();
        employee.setId(employeeDto.getId());
        employee.setName(employee.getName());
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }
}
