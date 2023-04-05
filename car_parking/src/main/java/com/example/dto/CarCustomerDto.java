package com.example.dto;

import java.util.List;

public class CarCustomerDTO {
    CustomerDTO customerDto;
    List<CarDTO> carDTOS;

    public CustomerDTO getCustomerDto() {
        return customerDto;
    }

    public void setCustomerDto(CustomerDTO customerDto) {
        this.customerDto = customerDto;
    }

    public List<CarDTO> getCarDtos() {
        return carDTOS;
    }

    public void setCarDtos(List<CarDTO> carDTOS) {
        this.carDTOS = carDTOS;
    }
}
