package com.example.service.impl;

import com.example.dto.ICarInOutDTO;
import com.example.repository.ICarInOutRepository;
import com.example.service.ICarInOutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CarInOutService implements ICarInOutService {
    @Autowired
    private ICarInOutRepository iCarInOutRepository;


    @Override
    public List<ICarInOutDTO> searchCarInDtoByNameByCustomerNameByPhoneNumber(String carPlateNumber, String customerName, String customerPhoneNumber) {
        return iCarInOutRepository.searchCarInDTOByCustomerNameByPhoneNumberByPlateNumber("%" + carPlateNumber + "%", "%" + customerName + "%", "%" + customerPhoneNumber + "%");
    }

    @Override
    public List<ICarInOutDTO> searchCarOutDTOByCustomerNameByPhoneNumberByPlateNumber(String carPlateNumber, String customerName, String customerPhoneNumber) {
        return iCarInOutRepository.searchCarOutDTOByCustomerNameByPhoneNumberByPlateNumber("%" + carPlateNumber + "%", "%" + customerName + "%", "%" + customerPhoneNumber + "%");
    }
}
