package com.example.service.impl;

import com.example.dto.ICarInOutDTO;
import com.example.repository.ICarInOutRepository;
import com.example.service.ICarInOutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarInOutService implements ICarInOutService {
    @Autowired
    private ICarInOutRepository iCarInOutRepository;

    @Override
    public List<ICarInOutDTO> searchCarInOutDtoByNameByCustomerNameByPhoneNumber(String carPlateNumber,
                                                                                 String customerName,
                                                                                 String customerPhoneNumber) {
        return iCarInOutRepository.searchCarInOutDtoByNameByCustomerNameByPhoneNumber(carPlateNumber,
                customerName,
                customerPhoneNumber);
    }
}
