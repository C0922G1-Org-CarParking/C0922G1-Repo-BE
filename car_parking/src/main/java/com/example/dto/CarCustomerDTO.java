package com.example.dto;

import javax.validation.Valid;
import java.util.List;

public class CarCustomerDTO {
    @Valid
    CustomerDTO customerDto;
    @Valid
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

