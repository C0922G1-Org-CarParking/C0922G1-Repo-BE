package com.example.controller.ticket;

import com.example.dto.*;
import com.example.model.*;
import com.example.repository.customer.ICustomerRepository;
import com.example.service.customer.ICustomerService;
import com.example.service.employee.IEmployeeService;
import com.example.service.location.ILocationService;
import com.example.service.ticket.ITicketService;
import com.example.service.ticket_type.ITicketTypeService;
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
    @Autowired
    private ICustomerService iCustomerService;

    /**
     * Created by: HuyNV
     * Date created: 29/03/2023
     * Function: createTicket
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
     * @param
     * @return  HttpStatus.BAD_REQUEST if result is null or HttpStatus.OK is result is not error
     */
    @GetMapping("/listTicketType")
    public ResponseEntity<List<ITicketTypeDto>> getListNameTicketType() {
        List<ITicketTypeDto> iTicketTypes = iTicketTypeService.getListNameTicketType();
        if (iTicketTypes.isEmpty()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(iTicketTypes,HttpStatus.OK);
    }
    /**
     * Created by: HuyNV
     * Date created: 29/03/2023
     * Function: getListLocation
     * @param
     * @return  HttpStatus.BAD_REQUEST if result is null or HttpStatus.OK is result is not error
     */
    @GetMapping("/listLocation")
    public ResponseEntity<List<ILocationDto>> getListLocation() {
       List<ILocationDto> iLocationDtos = iLocationService.getListNameLocation();
        if (iLocationDtos.isEmpty()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(iLocationDtos,HttpStatus.OK);
    }
    /**
     * Created by: HuyNV
     * Date created: 29/03/2023
     * Function: getListFloor
     * @param
     * @return  HttpStatus.BAD_REQUEST if result is null or HttpStatus.OK is result is not error
     */
    @GetMapping("/listFloor")
    public ResponseEntity<List<IFloorDto>> getListFloor() {
        List<IFloorDto> floorList = iLocationService.getListNameFloor();
        if (floorList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(floorList,HttpStatus.OK);
    }
    /**
     * Created by: HuyNV
     * Date created: 29/03/2023
     * Function: getListEmployee
     * @param
     * @return HttpStatus.BAD_REQUEST if result is null or HttpStatus.OK is result is not error
     */
    @GetMapping("/listSearchEmployee")
    public ResponseEntity<List<IEmployeeDto>> getListEmployee(@RequestParam(defaultValue = "") String name) {
        List<IEmployeeDto> employeeList = iEmployeeService.getListEmployeeByName(name);
        if (employeeList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(employeeList,HttpStatus.OK);
    }
    /**
     * Created by: HuyNV
     * Date created: 29/03/2023
     * Function: getNameChooseById
     * @param
     * @return HttpStatus.BAD_REQUEST if result is null or HttpStatus.OK is result is not error
     */
    @GetMapping("/chooseEmployee/{id}")
    public ResponseEntity<IEmployeeDto> getNameChooseById(@PathVariable("id") int id){
        IEmployeeDto iEmployeeDto = iEmployeeService.findEmployeeId(id);
        Employee employee = new Employee();
        employee.setId(iEmployeeDto.getId());
        employee.setName(iEmployeeDto.getTenNhanVien());
        if (employee == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(iEmployeeDto, HttpStatus.OK);
    }


    /**
     * Created by: HuyNV
     * Date created: 29/03/2023
     * Function: getListCustomer
     * @param
     * @return HttpStatus.BAD_REQUEST if result is null or HttpStatus.OK is result is not error
     */
    @GetMapping("/listSearchCustomer")
    public ResponseEntity<List<ICustomerDto>> getListCustomer(@RequestParam(defaultValue = "") String name) {
        List<ICustomerDto> customerDtoList = iCustomerService.getListCustomerByName(name);
        if (customerDtoList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(customerDtoList,HttpStatus.OK);
    }


    @GetMapping("/chooseCustomer/{id}")
    public ResponseEntity<ICustomerDto> getNameCustomerChooseById(@PathVariable("id") int id){
        ICustomerDto iCustomerDto = iCustomerService.findCustomerId(id);
        Customer customer = new Customer();
        customer.setId(iCustomerDto.getId());
        customer.setName(iCustomerDto.getName());
        customer.setDateOfBirth(iCustomerDto.getDayOfBirth());
        customer.setPhoneNumber(iCustomerDto.getPhoneNumber());
        if (customer == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(iCustomerDto, HttpStatus.OK);
    }


    /**
     * Created by: HuyNV
     * Date created: 29/03/2023
     * Function: getStatisticalChart
     * @param
     * @return HttpStatus.BAD_REQUEST if result is null or HttpStatus.OK is result is not error
     */
    @GetMapping("/statisticalTicketChart")
    public ResponseEntity<List<ITicketDto>> getStatisticalTicketChart(int sinceMonth , int toMonth){
        List<ITicketDto> tickets = iTicketService.statisticalChart(sinceMonth,toMonth);

        if (tickets.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(tickets,HttpStatus.OK);
    }


    @GetMapping("/statisticalCustomerChart")
    public ResponseEntity<List<ICustomerDto>> getStatisticalCustomerChart(int sinceMonth , int toMonth){
        List<ICustomerDto> customerDtoList = iCustomerService.statisticalChart(sinceMonth,toMonth);
        if (customerDtoList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(customerDtoList,HttpStatus.OK);
    }








}
