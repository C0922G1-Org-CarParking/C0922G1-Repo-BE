package com.example.controller;

import com.example.dto.*;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.example.model.Car;
import com.example.model.CarType;
import com.example.model.Customer;
import com.example.service.ICarService;
import com.example.service.ICarTypeService;
import com.example.service.ICustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/customer")
public class CustomerRestController {
    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private ICustomerService customerService;
    @Autowired
    private ICarService carService;
    @Autowired
    private ICarTypeService carTypeService;


    /**
     * Created by: MinhCDK
     * Date created: 03/04/2023
     * Function: getListCarType
     */

    @GetMapping("/carType")
    public ResponseEntity<List<CarType>> getAllCarType() {
        List<CarType> carTypeList = carTypeService.getAllCarType();
        if (carTypeList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(carTypeList, HttpStatus.OK);
        }
    }

    /**
     * Created by: MinhCDK
     * Date created: 03/04/2023
     * Function: findByCustomerId
     */

    @GetMapping("/info/{customerId}")
    public ResponseEntity<?> findByCustomerId(@PathVariable("customerId") Long customerId) {
        ICustomerDTO icustomerDto = customerService.findByCustomerId(customerId);
        if (customerId == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(icustomerDto, HttpStatus.OK);
    }

    /**
     * Created by: MinhCDK
     * Date created: 29/03/2023
     * Function: createCustomer
     */

    @PostMapping("/create")
    public ResponseEntity<?> createCustomer(@Validated @RequestBody CarCustomerDto carCustomerDto, BindingResult bindingResult) {
        CustomerDto customerDto = carCustomerDto.getCustomerDto();
        List<CarDto> carDtos = carCustomerDto.getCarDtos();
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.BAD_REQUEST);
        } else {
            customerService.createCustomer(customerDto.getCommune(), customerDto.getDateOfBirth(), customerDto.getDistrict(),
                    customerDto.getEmail(), customerDto.isGender(), customerDto.getIdCard(), customerDto.getName(), customerDto.getPhoneNumber(),
                    customerDto.getProvince(), customerDto.getStreet());
            Customer customer = customerService.findCustomerByIdCard(customerDto.getIdCard());
            for (CarDto car : carDtos) {
                carService.createCar(car.getBrand(), car.getName(), car.getPlateNumber(), car.getCarType().getId(), customer.getId());
            }
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Create by: VuTN,
     * Date create : 29/03/2023
     * Function : find customer by id
     *
     * @return HttpStatus.NOT_FOUND if result= null else then return customerCarDto and HttpStatus.OK
     * @Param id
     */
    @GetMapping("/findCustomer/{id}")
    public ResponseEntity<Customer> findCustomerById(@PathVariable Long id) {
        Customer customer = this.customerService.findCustomerById(id);
        if (customer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(customer, HttpStatus.OK);
        }
    }

    /**
     * Create by: VuTN,
     * Date create : 29/03/2023
     * Function : find car by id
     *
     * @return HttpStatus.NOT_FOUND if result= null else then return customerCarDto and HttpStatus.OK
     * @Param id
     */
@GetMapping("/car/{id}")
public  ResponseEntity<List<Car>> findCarById(@PathVariable Long id){
        List<Car> carList = this.carService.findCarById(id);
        if (carList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(carList,HttpStatus.OK);
        }
}
    /**
     * Create by: VuTN,
     * Date create : 29/03/2023
     * Function : update customer
     *
     * @return HttpStatus.EXPECTATION_FAILED if result is error else then return customerCarDto object
     * @Param id_customer
     * @RequestBody CustomerCarDto includes the customer object and the car object list
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<CustomerCarDto> updateCustomer(@PathVariable Long id, @RequestBody @Validated CustomerCarDto customerCarDto,
                                            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
        CustomerCarDto customerDto = customerCarDto;
        List<CarDto> carDtos = customerCarDto.getCarList();
        Customer customer = new Customer();
        List<Car> carList = new ArrayList<>();

        BeanUtils.copyProperties(customerDto, customer);
        this.customerService.updateCustomer(customer.getName(), customer.getIdCard(), customer.getDateOfBirth(), customer.isGender(), customer.getEmail(), customer.getPhoneNumber(), customer.getProvince(),
                customer.getDistrict(), customer.getCommune(), customer.getStreet(), id);


        List<Car> existingCars = carService.listCar(id);
            if (existingCars.isEmpty()) {
                for (int i = 0; i < carDtos.size(); i++) {
                    Car car2 = new Car();
                    BeanUtils.copyProperties(carDtos.get(i), car2);
                    carList.add(car2);
                }
                for (int i = 0; i < carList.size(); i++) {
                    Car car = new Car();
                    car = carList.get(i);
                    this.carService.createCar(car.getName(), car.getCarType().getId(), car.getBrand(), car.getPlateNumber(), car.getCustomer().getId());
                }
            } else {
                existingCars.stream()
                        .filter(car -> carDtos.stream()
                                .noneMatch(carDto -> carDto.getPlateNumber().equals(car.getPlateNumber())))
                        .forEach(car -> carService.deleteCar(car.getPlateNumber()));

                for (CarDto carDto : carDtos) {
                    boolean carExists = false;
                    for (Car existingCar : existingCars) {
                        if (existingCar.getPlateNumber().equals(carDto.getPlateNumber())) {
                            carExists = true;
                            break;
                        }
                    }
                    if (!carExists) {
                        Car car = new Car();
                        BeanUtils.copyProperties(carDto, car);
                        this.carService.createCar(car.getName(), car.getCarType().getId(), car.getBrand(), car.getPlateNumber(), car.getCustomer().getId());
                    }
                }
            }


        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Create by: VuBD
     * Date create: 29/03/2023
     * Function: connect service to get data corresponding to the search data
     *
     * @param name
     * @param idCard
     * @param phoneNumber
     * @param starDate
     * @param endDate
     * @param page
     * @return
     */
    @GetMapping("/list")
    public ResponseEntity<Page<ICustomerDTO>> getListCustomer(@RequestParam(required = false, defaultValue = "") String name,
                                                              @RequestParam(required = false, defaultValue = "") String idCard,
                                                              @RequestParam(required = false, defaultValue = "") String phoneNumber,
                                                              @RequestParam(required = false, defaultValue = "") String starDate,
                                                              @RequestParam(required = false, defaultValue = "") String endDate,
                                                              @RequestParam(required = false, defaultValue = "0") int page,
                                                              @RequestParam(required = false, defaultValue = "2") int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        Page<ICustomerDTO> customerPage = this.customerService.getListCustomer(name, idCard, phoneNumber, starDate, endDate, pageable);
        if (customerPage.getContent().isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(customerPage, HttpStatus.OK);
    }

    /**
     * Create by: VuBD
     * Date create: 01/04/2023
     * Function: connect service to get data a customer with corresponding id
     *
     * @param
     */
    @GetMapping("{id}")
    public ResponseEntity<ICustomerDTO> getCustomer(@PathVariable int id) {
        if (customerService.findById(id) != null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(customerService.findById(id), HttpStatus.OK);
    }

    /**
     * Create by: VuBD
     * Date create: 29/03/2023
     * Function: connect service to delete a customer with corresponding id
     *
     * @param id
     * @return: If successful, return ResponseEntity<>(HttpStatus.OK), if unsuccessful,
     * return ResponseEntity<>(HttpStatus.NOT_FOUND)
     * if the customer is still valid for tickets ResponseEntity<>(HttpStatus.NOT_FOUND)
     */
    @DeleteMapping("/{id}/delete")
    public ResponseEntity deleteCustomer(@PathVariable int id) {
        long status = customerService.deleteCustomer(id);
        if (status == 1) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else if (status == 0) {
            return new ResponseEntity<>(HttpStatus.METHOD_NOT_ALLOWED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * VuBD
     * Date create: 03/04/2023
     * Function: send email to customer when deleting a customer with ticket validity
     *
     * @param to
     * @param id
     * @return
     */
    @PostMapping("/send")
    public ResponseEntity<String> sendEmail(@RequestParam String to, @RequestBody Integer id) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject("Xác nhận xóa khách hàng.");
        message.setText("Vé của bạn còn thời hạn, có nên xóa hay không. Nếu muốn xóa thì bấm vào link này: " +
                "http://localhost:8080/customer/delete/" + id);
        try {
            javaMailSender.send(message);
            return  new ResponseEntity<>("Mail của bạn đã được gửi.", HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to send email: " + e.getMessage());
        }
    }

    /**
     * VuBD
     * Date create: 03/04/2023
     * Function: delete customers with valid tickets when customers decide to click on the delete link
     *
     * @param id
     * @return
     */
    @GetMapping("/delete/{id}")
    public ResponseEntity<String> deleteCustomerAndTicket(@PathVariable int id){
        customerService.deleteCustomerAndTicket(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

