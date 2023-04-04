package com.example.service;

import com.example.dto.ICarInOutDTO;
import com.example.model.CarInOut;
import com.example.repository.ICarInOutRepository;
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
    public ICarInOutDTO searchCarInOut(String plateNumber) {
        return carInOutRepository.searchCarInOutDTO(plateNumber);
    }
}
