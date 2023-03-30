package com.example.service.car_in_out;

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
    public void saveCarInOut(CarInOut carInOut) {
        iCarInOutRepository.saveCarInOut(carInOut.getCar().getId(), carInOut.getTimeIn(), carInOut.getTimeOut());
    }

    @Override
    public ICarInOutDTO searchCarInOutDTO(String plateNumber) {
        return iCarInOutRepository.searchCarInOutDTO(plateNumber);
    }
}
