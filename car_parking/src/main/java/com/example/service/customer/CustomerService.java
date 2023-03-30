package com.example.service.customer;

import com.example.dto.ICustomerDto;
import com.example.repository.customer.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService{
    @Autowired private ICustomerRepository iCustomerRepository;

    @Override
    public List<ICustomerDto> getListCustomerByName(String name) {
        return iCustomerRepository.getListCustomerByName(name);
    }

    @Override
    public ICustomerDto findCustomerId(int id) {
        return iCustomerRepository.getCustomerById(id);
    }

    @Override
    public List<ICustomerDto> statisticalChart(int sinceMonth, int toMonth) {
        return iCustomerRepository.getstatisticalChart(sinceMonth,toMonth);
    }
}