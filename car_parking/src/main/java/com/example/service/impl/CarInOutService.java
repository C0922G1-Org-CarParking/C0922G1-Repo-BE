package com.example.service.impl;

import com.example.dto.ICarInOutDTO;
import com.example.model.CarInOut;
import com.example.repository.ICarInOutRepository;
import com.example.service.ICarInOutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarInOutService implements ICarInOutService {
    @Autowired

    private ICarInOutRepository iCarInOutRepository;

    @Override
    public void saveCarIn(CarInOut carIn) {
        iCarInOutRepository.saveCarIn(carIn.getCar().getId(), carIn.getTimeIn(), carIn.getUrlCarInImage());
        iCarInOutRepository.updateCarIn(carIn.getCar().getId());
    }

    @Override
    public ICarInOutDTO searchCarInDtoByScanning(String plateNumber) {
        return iCarInOutRepository.searchCarInDTOByScanning(plateNumber);
    }

    @Override
    public void saveCarOut(CarInOut carOut) {
        iCarInOutRepository.saveCarOut(carOut.getTimeOut(), carOut.getId(), carOut.getUrlCarOutImage());
        iCarInOutRepository.updateCarOut(carOut.getCar().getId());
    }


    @Override
    public ICarInOutDTO searchCarOutDTOByScanning(String plateNumber) {
        return iCarInOutRepository.searchCarOutDTOByScanning(plateNumber);
    }


    @Override
    public List<ICarInOutDTO> searchCarInDtoByNameByCustomerNameByPhoneNumber(String carPlateNumber, String customerName, String customerPhoneNumber) {
        return iCarInOutRepository.searchCarInDTOByCustomerNameByPhoneNumberByPlateNumber("%" + carPlateNumber + "%", "%" + customerName + "%", "%" + customerPhoneNumber + "%");
    }

    @Override
    public List<ICarInOutDTO> searchCarOutDTOByCustomerNameByPhoneNumberByPlateNumber(String carPlateNumber, String customerName, String customerPhoneNumber) {
        return iCarInOutRepository.searchCarOutDTOByCustomerNameByPhoneNumberByPlateNumber("%" + carPlateNumber + "%", "%" + customerName + "%", "%" + customerPhoneNumber + "%");
    }

}
