package com.example.service;

import com.example.dto.ICarInOutDTO;
import com.example.model.CarInOut;

public interface ICarInOutService {
    void saveCarInOut(CarInOut carInOut);

    ICarInOutDTO searchCarInOut(String plateNumber);

}
