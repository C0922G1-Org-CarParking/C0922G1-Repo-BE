package com.example.controller.customer_car;

import com.example.dto.CustomerCarDto;
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

    /*
     *  Create by: VuTN,
     *  Date create : 29/03/2023
     *  Function : find customer by id
     *
     *  @Param id
     *  @return  HttpStatus.NOT_FOUND if result= null else then return customerCarDto and HttpStatus.OK
     * */
    @GetMapping("/info/{id}")
    public ResponseEntity<List<ICarDto>> findCustomerById(@PathVariable Long id) {
        List<ICarDto> customerCarDto = this.customerService.findCustomerById(id);
        if (customerCarDto == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(customerCarDto, HttpStatus.OK);
        }
    }

    /*
     *  Create by: VuTN,
     *  Date create : 29/03/2023
     *  Function : update customer
     *
     *  @Param id_customer
     *  @RequestBody CustomerCarDto includes the customer object and the car object list
     *  @return  HttpStatus.EXPECTATION_FAILED if result is error else then return customerCarDto object
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateCustomer(@PathVariable Long id, @RequestBody @Validated CustomerCarDto customerCarDto,
                                            BindingResult bindingResult) {
        Customer customer1 = customerCarDto.getCustomer();
        List<Car> car1 = customerCarDto.getCars();
        Customer customer = new Customer();
        List<Car> carList = new ArrayList<>();
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        } else {
            BeanUtils.copyProperties(customer1, customer);
            this.customerService.updateCustomer(customer.getName(), customer.getIdCard(), customer.getDateOfBirth(), customer.isGender(), customer.getEmail(), customer.getPhoneNumber(), customer.getProvince(),
                    customer.getDistrict(), customer.getCommune(), customer.getStreet(), id);
            List<Car> carList1 = this.carService.listCar(id);

            for (int i = 0; i < car1.size(); i++) {
                for (int j = 0; j < carList1.size(); j++) {
                    if (carList1.get(j).getId() == car1.get(i).getId()) {
                        continue;
                    }
                    this.carService.deleteCar(carList1.get(j).getId());
                }
            }

            for (int i = 0; i < car1.size(); i++) {
                carList.add(car1.get(i));
            }

            for (int i = 0; i < carList1.size(); i++) {
                for (int j = 0; j < carList.size(); j++) {
                    if (carList.get(j).getId() != carList1.get(i).getId()) {

                        Car car = carList.get(j);
                        this.carService.createCar(car.getName(), car.getCarType().getId(), car.getBrand(), car.getPlateNumber(), car.getCustomer().getId());
                    }
                }
            }
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
