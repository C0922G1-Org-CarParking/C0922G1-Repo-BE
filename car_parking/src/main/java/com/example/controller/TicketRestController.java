package com.example.controller;

import com.example.dto.*;
import com.example.model.*;
import com.example.service.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin("*")
@RequestMapping("/ticket")
public class TicketRestController {
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
    @Autowired
    private IFloorService iFloorService;


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
        iTicketService.addTicket(ticket.getEffectiveDate(), ticket.getExpiryDate(), ticket.isDeleted(), ticket.getTotalPrice(), ticket.getCar().getId(), ticket.getEmployee().getId(), ticket.getLocation().getId(), ticket.getTicketType().getId(), ticket.getPrice());
        ticket.getLocation().setOccupied(true);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Created by: HuyNV
     * Date created: 29/03/2023
     * Function: getListNameTicketType
     *
     * @param
     * @return HttpStatus.BAD_REQUEST if result is null or HttpStatus.OK is result is not error
     */
    @GetMapping("/listTicketType")
    public ResponseEntity<List<ITicketTypeDto>> getListNameTicketType() {
        List<ITicketTypeDto> iTicketTypes = iTicketTypeService.getAllTicketTypes();
        if (iTicketTypes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(iTicketTypes, HttpStatus.OK);
    }

    /**
     * Created by: HuyNV
     * Date created: 29/03/2023
     * Function: getListLocation
     *
     * @param
     * @return HttpStatus.BAD_REQUEST if result is null or HttpStatus.OK is result is not error
     */
    @GetMapping("/listLocation")
    public ResponseEntity<List<ILocationDto>> getListLocation() {
        List<ILocationDto> iLocationDtos = iLocationService.getListNameLocation();
        if (iLocationDtos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(iLocationDtos, HttpStatus.OK);
    }

    /**
     * Created by: HuyNV
     * Date created: 29/03/2023
     * Function: getListFloor
     *
     * @param
     * @return HttpStatus.BAD_REQUEST if result is null or HttpStatus.OK is result is not error
     */
    @GetMapping("/listFloor")
    public ResponseEntity<List<IFloorDto>> getListFloor() {
        List<IFloorDto> floorList = iLocationService.getListNameFloor();
        if (floorList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(floorList, HttpStatus.OK);
    }

    /**
     * Created by: HuyNV
     * Date created: 29/03/2023
     * Function: getListEmployee
     *
     * @param
     * @return HttpStatus.BAD_REQUEST if result is null or HttpStatus.OK is result is not error
     */
    @GetMapping("/listEmployee")
    public ResponseEntity<List<IEmployeeDto>> getListEmployee() {
        List<IEmployeeDto> employeeList = iEmployeeService.getListEmployeeByName();
        if (employeeList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(employeeList, HttpStatus.OK);
    }



    /**
     * Created by: HuyNV
     * Date created: 29/03/2023
     * Function: getListCustomer
     *
     * @param
     * @return HttpStatus.BAD_REQUEST if result is null or HttpStatus.OK is result is not error
     */
    @GetMapping("/listSearchCustomer")
    public ResponseEntity<List<ICustomerDto>> getListCustomer(@RequestParam(defaultValue = "") String name) {
        List<ICustomerDto> customerDtoList = iCustomerService.getListCustomerByName(name);
        if (customerDtoList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(customerDtoList, HttpStatus.OK);
    }


    @GetMapping("/chooseCustomer/{id}")
    public ResponseEntity<?> getNameCustomerChooseById(@PathVariable("id") int id) {
        ICustomerDto iCustomerDto = iCustomerService.findCustomerId(id);
        Customer customer = new Customer();
        customer.setId(iCustomerDto.getId());
        customer.setName(iCustomerDto.getName());
        customer.setPhoneNumber(iCustomerDto.getPhoneNumber());
        if (iCustomerDto == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }


    /**
     * Created by: HuyNV
     * Date created: 29/03/2023
     * Function: getStatisticalTicketChart
     *
     * @param
     * @return HttpStatus.BAD_REQUEST if result is null or HttpStatus.OK is result is not error
     */
    @GetMapping("/statisticalTicketChart/{sinceMonth}/{toMonth}")
    public ResponseEntity<List<ITicketDto>> getStatisticalTicketChart(@PathVariable int sinceMonth,@PathVariable int toMonth) {
        List<ITicketDto> tickets = iTicketService.statisticalChart(sinceMonth, toMonth);
        if (tickets.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(tickets, HttpStatus.OK);
    }

    /**
     * Created by: HuyNV
     * Date created: 29/03/2023
     * Function: getStatisticalCustomerChart
     *
     * @param
     * @return HttpStatus.BAD_REQUEST if result is null or HttpStatus.OK is result is not error
     */
    @GetMapping("/statisticalCustomerChart/{sinceMonth}/{toMonth}")
    public ResponseEntity<List<ICustomerDto>> getStatisticalCustomerChart(@PathVariable int sinceMonth, @PathVariable int toMonth) {
        List<ICustomerDto> customerDtoList = iCustomerService.statisticalChart(sinceMonth, toMonth);
        if (customerDtoList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(customerDtoList, HttpStatus.OK);
    }

    /**
     * Created by: HuyNV
     * Date created: 29/03/2023
     * Function: getStatisticalCustomerChart
     *
     * @param
     * @return HttpStatus.BAD_REQUEST if result is null or HttpStatus.OK is result is not error
     */
    @GetMapping("/getPrice")
    public ResponseEntity<Integer> getPriceOfTicket(@RequestParam(value = "expiryDate", defaultValue = "") String expiryDate
            ,@RequestParam(value = "effectiveDate",defaultValue = "") String effectiveDate
            ,@RequestParam(value = "rate",defaultValue = "") Double rate){
        Integer price = null;
        if (!effectiveDate.equals("") && !expiryDate.equals("") && !(rate == 0)) {
             price = iTicketService.getPriceOfTicket(expiryDate,effectiveDate,rate);
        }

        if (price == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(price, HttpStatus.OK);
    }

    @GetMapping("/findCarListOfCustomerId/{id}")
    public ResponseEntity<List<ICarDto>> findCarListOfCustomerId(@PathVariable("id") int id) {
        List<ICarDto> iCarDto = iCustomerService.findCarListOfCustomerId(id);
        if (iCarDto == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(iCarDto, HttpStatus.OK);
    }

    @GetMapping("/displayMonth/{sinceMonth}/{toMonth}")
    public ResponseEntity<?> getMonth(@PathVariable int sinceMonth,@PathVariable int toMonth) {
        List<ITicketDto> tickets = iTicketService.displayMonth(sinceMonth, toMonth);
        if (tickets.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(tickets, HttpStatus.OK);
    }


    @GetMapping("/rate/{id}")
    public ResponseEntity<Double> getRate(@PathVariable("id") int id) {
        double rate = iCustomerService.findRateById(id);

        if (rate == 0 ) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(rate, HttpStatus.OK);
    }



    /**
     * Created by: HuyNL
     * Date created: 29/03/2023
     * Function: edit Ticket
     * @return HttpStatus.No_Content if result is null or HttpStatus.OK is result is not error
     */
    @GetMapping("/{id}")
    private ResponseEntity<ITicketDto> findTicketById(@PathVariable("id") Long id) {
        ITicketDto editTicketDto = iTicketService.findTicket(id);
        if (editTicketDto == null || id == null || id == -1) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(editTicketDto, HttpStatus.OK);
    }

    /**
     * Created by: HuyNL
     * Date created: 29/03/2023
     * Function: edit Ticket
     * @return HttpStatus.No_Content if result is null or HttpStatus.OK is result is not error
     */
    @PutMapping("/update/{id}")
    private ResponseEntity<?> updateTicket(@Validated @RequestBody EditTicketDto editTicketDto,
                                           BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return new ResponseEntity<>(bindingResult.getAllErrors(),HttpStatus.BAD_REQUEST);
        }
        iTicketService.updateTicket(
                editTicketDto.getTicketTypeId(),
                editTicketDto.getFloorId(),
                editTicketDto.getSectionId(),
                editTicketDto.getExpiryDate(),
                editTicketDto.getId()
        );
        return new ResponseEntity<>(HttpStatus.OK);
    }


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
            ticketPage = iTicketService.searchTicketExpired(customerName, customerPhone, employeeName, employeePhone, floor, ticketType, pageable);
        } else {
            ticketPage = iTicketService.searchTicketList(customerName, customerPhone, employeeName, employeePhone, floor, expiryDate, ticketType, status, pageable);
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
     * @return: HttpStatus.NO_CONTENT when not has content or List<Floor> and HttpStatus.Ok when has content
     */

    @GetMapping("/floor")
    public ResponseEntity<List<Floor>> findAllFloor() {
        List<Floor> floorList = iFloorService.getAllFloor();
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
        List<TicketType> ticketTypeList = iTicketTypeService.findAll();
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
        TicketOfListDto ticket = iTicketService.findTicketDetailById(id);
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
     *
     * @param: id
     * @return: HttpStatus.INTERNAL_SERVER_ERROR when exception occurs or Ticket and HttpStatus.Ok when delete success
     */

    @DeleteMapping("delete/{idDelete}")
    public ResponseEntity<Boolean> deleteTicket(@PathVariable("idDelete") int idDelete) {
        if (iTicketService.delete(idDelete)) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
