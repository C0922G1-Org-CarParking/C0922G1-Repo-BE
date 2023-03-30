package com.example.service;

import com.example.dto.ICarInOutDTO;
import com.example.model.CarInOut;
import com.example.repository.car_in_out.ICarInOutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarInOutService implements ICarInOutService {
    @Autowired
    private ICarInOutRepository iCarInOutRepository;

    @Override
    public void saveCarIn(CarInOut carInOut) {
        iCarInOutRepository.saveCarIn(carInOut.getCar().getId(), carInOut.getTimeIn(), carInOut.isParked());
    }

    @Override
    public ICarInOutDTO searchCarInOutDTO(String plateNumber) {
        return iCarInOutRepository.searchCarInOutDTO(plateNumber);
    }

    @Override
    public void saveCarOut(CarInOut carInOut) {
        iCarInOutRepository.saveCarOut(carInOut.getTimeOut(), carInOut.getId(), carInOut.isParked());
    }

    @Override
    public CarInOut findCarInByCarId(Long id) {
        return iCarInOutRepository.findCarInByCarId(id);
    }
}
