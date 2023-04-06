package com.example.service;

import com.example.dto.ICarInOutDTO;
import com.example.model.CarInOut;
import java.util.List;

public interface ICarInOutService {
    void saveCarIn(CarInOut carInOut);

    ICarInOutDTO searchCarInDtoByScanning(String plateNumber);

    void saveCarOut(CarInOut carOut);

    ICarInOutDTO searchCarOutDTOByScanning(String plateNumber);

    List<ICarInOutDTO> searchCarInDtoByNameByCustomerNameByPhoneNumber(String carPlateNumber,
                                                                       String customerName,
                                                                       String customerPhoneNumber);

    List<ICarInOutDTO> searchCarOutDTOByCustomerNameByPhoneNumberByPlateNumber(String carPlateNumber,
                                                                               String customerName,
                                                                               String customerPhoneNumber);

    ICarInOutDTO searchCarInOut(String plateNumber);

}
