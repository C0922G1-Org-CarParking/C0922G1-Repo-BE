package com.example.service.impl;

import com.example.dto.ICarInOutDto;
import com.example.model.CarInOut;
import com.example.repository.ICarInOutRepository;
import com.example.service.ICarInOutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarInOutService implements ICarInOutService {
    @Autowired
    private ICarInOutRepository carInOutRepository;

    @Override
    public void saveCarInOut(CarInOut carInOut) {
        carInOutRepository.saveCarInOut(carInOut.getCar().getId(), carInOut.getTimeIn(), carInOut.getTimeOut());
    }

    @Override
    public ICarInOutDto searchCarInOut(String plateNumber) {
        return carInOutRepository.searchCarInOutDTO(plateNumber);
    }
}
