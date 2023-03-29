package com.example.service.car_in_out;

import com.example.dto.ICarInOutDto;
import com.example.model.CarInOut;
import com.example.repository.car_in_out.ICarInOutRepository;
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
