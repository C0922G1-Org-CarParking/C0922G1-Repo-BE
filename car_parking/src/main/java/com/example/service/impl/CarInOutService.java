package com.example.service.impl;

import com.example.dto.ICarInOutDTO;
import com.example.model.CarInOut;
import com.example.repository.ICarInOutRepository;
import com.example.service.ICarInOutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CarInOutService implements ICarInOutService {
    @Autowired
    private ICarInOutRepository iCarInOutRepository;

    @Override
    public void saveCarIn(CarInOut carIn) {
        iCarInOutRepository.saveCarIn(carIn.getCar().getId(), carIn.getTimeIn(), carIn.isParked(), carIn.getUrlCarInImage());
    }

    @Override
    public ICarInOutDTO searchCarInDto(String plateNumber) {
        return iCarInOutRepository.searchCarInDTOByScanning(plateNumber);
    }

    @Override
    public void saveCarOut(CarInOut carOut) {
        iCarInOutRepository.saveCarOut(carOut.getTimeOut(), carOut.getId(), carOut.isParked(), carOut.getUrlCarOutImage());
    }


    @Override
    public ICarInOutDTO searchCarOutDTO(String plateNumber) {
        return iCarInOutRepository.searchCarOutDTOByScanning(plateNumber);
    }

}
