package com.example.service;

import com.example.dto.ICarInOutDTO;
import com.example.model.CarInOut;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICarInOutService {
    void saveCarIn(CarInOut carInOut);

    ICarInOutDTO searchCarInDto(String plateNumber);

    void saveCarOut(CarInOut carOut);

    ICarInOutDTO searchCarOutDTO(String plateNumber);

}
