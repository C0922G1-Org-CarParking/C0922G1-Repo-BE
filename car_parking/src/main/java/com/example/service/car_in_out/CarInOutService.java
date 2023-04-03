package com.example.service.car_in_out;

import com.example.dto.ICarInOutDTO;
import com.example.model.CarInOut;
import com.example.repository.car_in_out.ICarInOutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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


    /**
     * Created by: HuyNL
     * Date created: 29/03/2023
     * Function: searchCar and showList Car
     */

    @Override
    public Page<ICarInOutDTO> searchCarInOut(String carPlateNumber, String customerPhoneNumber, String customerName, Pageable pageable) {
        return carInOutRepository.searchCarInOutListDto(carPlateNumber, customerPhoneNumber, customerName, pageable);
    }

    @Override
    public ICarInOutDTO findCarById(Long id) {
        return carInOutRepository.findCarById(id);
    }

}
