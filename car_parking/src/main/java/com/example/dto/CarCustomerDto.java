package com.example.dto;

import java.util.List;

public class CarCustomerDto {
    CustomerDto customerDto;
    List<CarDto> carDtos;

    public CustomerDto getCustomerDto() {
        return customerDto;
    }

    public void setCustomerDto(CustomerDto customerDto) {
        this.customerDto = customerDto;
    }

    public List<CarDto> getCarDtos() {
        return carDtos;
    }

    public void setCarDtos(List<CarDto> carDtos) {
        this.carDtos = carDtos;
    }
}
