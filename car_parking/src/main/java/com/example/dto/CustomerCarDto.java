package com.example.dto;

import com.example.model.Car;
import com.example.model.Customer;

import javax.validation.Valid;
import java.util.List;

public class CustomerCarDto {
    @Valid
    private CustomerDto customer;
    @Valid
    private List<CarDto> cars;

    public CustomerCarDto() {
    }

    public CustomerDto getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDto customer) {
        this.customer = customer;
    }

    public List<CarDto> getCars() {
        return cars;
    }

    public void setCars(List<CarDto> cars) {
        this.cars = cars;
    }
}
