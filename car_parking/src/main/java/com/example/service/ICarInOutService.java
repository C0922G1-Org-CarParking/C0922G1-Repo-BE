package com.example.service;

import com.example.dto.ICarInOutDTO;
import com.example.model.CarInOut;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICarInOutService {
    void saveCarIn(CarInOut carInOut);

    ICarInOutDTO searchCarInDto(String plateNumber);

    void saveCarOut(CarInOut carOut);

    ICarInOutDTO searchCarOutDTO(String plateNumber);

    List<ICarInOutDTO> searchCarInDtoByNameByCustomerNameByPhoneNumber(String carPlateNumber,
                                                                       String customerName,
                                                                       String customerPhoneNumber);

    List<ICarInOutDTO> searchCarOutDTOByCustomerNameByPhoneNumberByPlateNumber(String carPlateNumber,
                                                                               String customerName,
                                                                               String customerPhoneNumber);


}
