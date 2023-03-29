package com.example.service.car_in_out;

import com.example.dto.ICarInOutDto;
import com.example.model.CarInOut;

public interface ICarInOutService {
    void saveCarInOut(CarInOut carInOut);

    ICarInOutDto searchCarInOut(String plateNumber);

}
