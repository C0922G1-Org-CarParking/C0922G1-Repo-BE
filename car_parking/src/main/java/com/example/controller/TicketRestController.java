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
@RequestMapping("api/user/ticket")
public class TicketRestController {
    @Autowired
    private ITicketService iTicketService;
    @Autowired
    private ITicketTypeService iticketTypeService;
    @Autowired
    private IEmployeeService iEmployeeService;
    @Autowired
    private IFloorService iFloorService;
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private ILocationService iLocationService;
    @Autowired
    private ISectionService iSectionService;

    /**
     * Created by: HuyNV
     * Date created: 29/03/2023
     * Function: createTicket
     *
     * @param ticketDto, bindingResult
     * @return HttpStatus.BAD_REQUEST if result is null or HttpStatus.OK is result is not error
     */
    @PostMapping("/createTicket")
    public ResponseEntity<Ticket> createTicket(@Validated @RequestBody TicketDTO ticketDto, BindingResult bindingResult) {
        new TicketDTO().validate(ticketDto, bindingResult);
         if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Ticket ticket = new Ticket();
        BeanUtils.copyProperties(ticketDto, ticket);
        iTicketService.addTicket(ticket.getEffectiveDate(), ticket.getExpiryDate(), ticket.isDeleted(), ticket.getTotalPrice(), ticket.getCar().getId(),
                ticket.getEmployee().getId(), ticket.getLocation().getId(), ticket.getTicketType().getId(), ticket.getPrice());
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
    public ResponseEntity<List<ITicketTypeDTO>> getListNameTicketType() {
        List<ITicketTypeDTO> iTicketTypes = iticketTypeService.getAllTicketTypes();
        if (iTicketTypes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(iTicketTypes, HttpStatus.OK);
    }

    @GetMapping("/listLocation")
    public ResponseEntity<List<ILocationOfFloorDTO>> getListLocation(@RequestParam(value = "floorId" , defaultValue = "") int floorId ,
                                                                  @RequestParam(value = "sectionId" , defaultValue = "") int sectionId) {
        List<ILocationOfFloorDTO> iLocationDtos = iLocationService.getListNameLocation(floorId,sectionId);
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
    public ResponseEntity<List<IFloorDTO>> getListFloor() {
        List<IFloorDTO> floorList = iLocationService.getListNameFloor();
        if (floorList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(floorList, HttpStatus.OK);
    }

    /**
     * Created by: HuyNV
     * Date created: 29/03/2023
     * Function: getListSection
     *
     * @param
     * @return HttpStatus.BAD_REQUEST if result is null or HttpStatus.OK is result is not error
     */
    @GetMapping("/listSection/{id}")
    public ResponseEntity<List<ISectionDTO>> getListSectionByFloorId(@PathVariable("id") int id) {
        List<ISectionDTO> iSectionDTOS = iSectionService.getListNameFloor(id);
        if (iSectionDTOS.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(iSectionDTOS, HttpStatus.OK);
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
    public ResponseEntity<List<IEmployeeDTO>> getListEmployee() {
        List<IEmployeeDTO> employeeList = iEmployeeService.getListEmployeeByName();
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
    public ResponseEntity<List<IListCustomerDTO>> getListCustomer(@RequestParam(defaultValue = "") String name) {
        List<IListCustomerDTO> customerDtoList = customerService.getListCustomerByName(name);
        if (customerDtoList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(customerDtoList, HttpStatus.OK);
    }


    @GetMapping("/chooseCustomer/{id}")
    public ResponseEntity<?> getNameCustomerChooseById(@PathVariable("id") int id) {
        ICustomerDTO iCustomerDto = customerService.findCustomerId(id);
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
     * Function: getStatisticalCustomerChart
     *
     * @param
     * @return HttpStatus.BAD_REQUEST if result is null or HttpStatus.OK is result is not error
     */
    @GetMapping("/statisticalCustomerChart")
    public ResponseEntity<Integer[]> getTotalStatisticalCustomerChart(@RequestParam(value = "sinceMonth", defaultValue = "") int sinceMonth
            , @RequestParam(value = "toMonth",defaultValue = "") int toMonth,
                                                                      @RequestParam(value = "year", defaultValue = "") int year) {
        Integer[] customers = iTicketService.getValue(sinceMonth, toMonth,year);
        if (customers == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }


    /**
     * Created by: HuyNV
     * Date created: 29/03/2023
     * Function: getStatisticalTicketChart
     *
     * @param
     * @return HttpStatus.BAD_REQUEST if result is null or HttpStatus.OK is result is not error
     */
    @GetMapping("/statisticalTicketChart")
    public ResponseEntity<Integer[]> getTotalStatisticalTicketChart(
            @RequestParam(value = "sinceMonth", defaultValue = "") int sinceMonth
            , @RequestParam(value = "toMonth",defaultValue = "") int toMonth,
            @RequestParam(value = "year", defaultValue = "") int year) {
        Integer[] tickets = iTicketService.getTicketList(sinceMonth, toMonth, year);
        if (tickets == null) {
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
    @GetMapping("/getPrice")
    public ResponseEntity<Double> getPriceOfTicket(@RequestParam(value = "expiryDate", defaultValue = "") String expiryDate
            , @RequestParam(value = "effectiveDate", defaultValue = "") String effectiveDate
            , @RequestParam(value = "rate", defaultValue = "") Double rate) {
        Double price = null;
        if (!effectiveDate.equals("") && !expiryDate.equals("") && !(rate == 0)) {
            price = Double.valueOf(iTicketService.getPriceOfTicket(expiryDate, effectiveDate, rate));
        }

        if (price == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(price, HttpStatus.OK);
    }

    /**
     * Created by: HuyNV
     * Date created: 29/03/2023
     * Function: getStatisticalCustomerChart
     *
     * @param
     * @return HttpStatus.BAD_REQUEST if result is null or HttpStatus.OK is result is not error
     */
    @GetMapping("/findCarListOfCustomerId/{id}")


    public ResponseEntity<List<ICarTicketDTO>> findCarListOfCustomerId(@PathVariable("id") int id) {
        List<ICarTicketDTO> iCarTicketDTO = customerService.findCarListOfCustomerId(id);
        if (iCarTicketDTO == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(iCarTicketDTO, HttpStatus.OK);
    }

    @GetMapping("/displayMonth/{sinceMonth}/{toMonth}")
    public ResponseEntity<?> getMonth(@PathVariable int sinceMonth, @PathVariable int toMonth) {
        List<ITicketDTO> tickets = iTicketService.displayMonth(sinceMonth, toMonth);
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
    @GetMapping("/rate/{id}")
    public ResponseEntity<Double> getRate(@PathVariable("id") int id) {
        double rate = customerService.findRateById(id);

        if (rate == 0) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(rate, HttpStatus.OK);
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
    public ResponseEntity<Page<TicketOfListDTO>> searchTicket(@RequestParam(value = "customerName", defaultValue = "") String customerName,
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
        Page<TicketOfListDTO> ticketPage;
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
            return new ResponseEntity<>
                    (floorList, HttpStatus.OK);
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
        List<TicketType> ticketTypeList = iticketTypeService.findAll();
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
    public ResponseEntity<TicketOfListDTO> detailTicket(@PathVariable("id") int id) {
        TicketOfListDTO ticket = iTicketService.findTicketDetailById(id);
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

        if (iTicketService.delete(idDelete)) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/get-price")
    public ResponseEntity<Integer> getRenewalPrice(@RequestParam(value = "expiryDate", required = false) String expiryDate,
                                                  @RequestParam(value = "effectiveDate", required = false) String effectiveDate,
                                                  @RequestParam(value = "rate", required = false) Double rate) {
        if (expiryDate == null || effectiveDate == null || rate == null) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        Integer price = this.iTicketService.getPriceOfTicket(expiryDate, effectiveDate, rate);
        return new ResponseEntity<>(price, HttpStatus.OK);
    }

    /**
     * Created by: HuyNL
     * Date created: 29/03/2023
     * Function: edit Ticket
     *
     * @return HttpStatus.No_Content if result is null or HttpStatus.OK is result is not error
     */


    @GetMapping("/edit/{id}")
    private ResponseEntity<ITicketDTO> findTicketById(@PathVariable("id") int id) {
        ITicketDTO editTicketDto = iTicketService.findTicket(id);

        if (editTicketDto == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(editTicketDto, HttpStatus.OK);
    }

    /**
     * Created by: HuyNL
     * Date created: 29/03/2023
     * Function: edit Ticket
     *
     * @return HttpStatus.No_Content if result is null or HttpStatus.OK is result is not error
     */

    @PutMapping("/update")
    private ResponseEntity<?> updateTicket(@RequestBody @Validated TicketDTOEdit ticketDTOEdit,
                                           BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.BAD_REQUEST);
        }
        iTicketService.updateTicket(ticketDTOEdit.getExpiryDate(),
                ticketDTOEdit.getLocationId(),
                ticketDTOEdit.getTicketTypeId(),
                ticketDTOEdit.getTotalPrice(),
                ticketDTOEdit.getId());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Created by: HuyNL
     * Date created: 29/03/2023
     *
     */

    @GetMapping("/statisticalCustomerChartRange")
    public ResponseEntity<Integer[]> getTotalStatisticalCustomerChartRange(
            @RequestParam(value = "sinceMonth", defaultValue = "") int sinceMonth
            ,@RequestParam(value = "toMonth",defaultValue = "") int toMonth,
            @RequestParam(value = "yearStart", defaultValue = "") int yearStart,
            @RequestParam(value = "yearEnd", defaultValue = "") int yearEnd) {
        Integer[] customerChartRange = iTicketService.getCustomerChartRange(sinceMonth, toMonth , yearStart , yearEnd);
        if (customerChartRange == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(customerChartRange, HttpStatus.OK);
    }

    /**
     * Created by: HuyNV
     * Date created: 29/03/2023
     * Function: getStatisticalCustomerChartRange
     *
     * @param
     * @return HttpStatus.BAD_REQUEST if result is null or HttpStatus.OK is result is not error
     */
    @GetMapping("/statisticalTicketChartRange")
    public ResponseEntity<Integer[]> getTotalStatisticalTicketChartRange(
            @RequestParam(value = "sinceMonth", defaultValue = "") int sinceMonth
            ,@RequestParam(value = "toMonth",defaultValue = "") int toMonth,
            @RequestParam(value = "yearStart",defaultValue = "") int yearStart,
            @RequestParam(value = "yearEnd",defaultValue = "") int yearEnd) {
        Integer[] ticketChartRange = iTicketService.getTicketChartRange(sinceMonth, toMonth , yearStart , yearEnd);
        if (ticketChartRange == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(ticketChartRange, HttpStatus.OK);
    }

}
