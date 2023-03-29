package com.example.service.customer;

import com.example.dto.ICustomerDto;

import java.util.List;

public interface ICustomerService {

    List<ICustomerDto> getListCustomerByName(String name);

    ICustomerDto findCustomerId(int id);

    List<ICustomerDto> statisticalChart(int sinceMonth, int toMonth);
}
