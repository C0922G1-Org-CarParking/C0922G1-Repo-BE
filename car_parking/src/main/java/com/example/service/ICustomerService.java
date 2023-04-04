package com.example.service;

import com.example.dto.ICarDto;
import com.example.dto.ICustomerDto;

import java.util.List;

public interface ICustomerService {

    List<ICustomerDto> getListCustomerByName(String name);

    ICustomerDto findCustomerId(int id);

    List<ICarDto> findCarListOfCustomerId(int id);

    double findRateById(int id);
}
