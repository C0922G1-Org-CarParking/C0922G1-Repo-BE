package com.example.controller.customer_car;

import com.example.dto.CarDto;
import com.example.dto.CustomerCarDto;
import com.example.dto.CustomerDto;
import com.example.dto.ICarDto;
import com.example.model.Car;
import com.example.model.CarType;
import com.example.model.Customer;
import com.example.service.customer_car.ICarService;
import com.example.service.customer_car.ICarTypeService;
import com.example.service.customer_car.ICustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@CrossOrigin("*")
@RequestMapping("/customer")
public class CustomerRestController {
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private ICarService carService;
    @Autowired
    private ICarTypeService carTypeService;

    /*
     *  Create by: VuTN,
     *  Date create : 29/03/2023
     *  Function : get all carType
     *
     *  @Param
     *  @return  HttpStatus.NO_CONTENT if result= isEmpty else then return carTypeList  and HttpStatus.OK
     * */
    @GetMapping("carType")
    public ResponseEntity<List<CarType>> getAllCarType() {
        List<CarType> carTypeList = this.carTypeService.getAllCarType();
        if (carTypeList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(carTypeList, HttpStatus.OK);
        }
    }

    /**
     * Create by: VuTN,
     * Date create : 29/03/2023
     * Function : find customer by id
     *
     * @return HttpStatus.NOT_FOUND if result= null else then return customerCarDto and HttpStatus.OK
     * @Param id
     */
    @GetMapping("/info/{id}")
    public ResponseEntity<List<ICarDto>> findCustomerById(@PathVariable Long id) {
        List<ICarDto> customerCarDto = this.customerService.findCustomerById(id);
        if (customerCarDto == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(customerCarDto, HttpStatus.OK);
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
    public ResponseEntity<?> updateCustomer(@PathVariable Long id, @RequestBody @Validated CustomerCarDto customerCarDto,
                                            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
        CustomerDto customerDto = customerCarDto.getCustomer();
        List<CarDto> carDtos = customerCarDto.getCars();
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

            carDtos.stream()
                    .forEach(carDto -> {
                        Car car = existingCars.stream()
                                .filter(c -> c.getPlateNumber().equals(carDto.getPlateNumber()))
                                .findFirst()
                                .orElse(new Car());
                        BeanUtils.copyProperties(carDto, car);
                        this.carService.createCar(car.getName(), car.getCarType().getId(), car.getBrand(), car.getPlateNumber(), car.getCustomer().getId());
                    });
        }


        return new ResponseEntity<>(HttpStatus.OK);
    }
}