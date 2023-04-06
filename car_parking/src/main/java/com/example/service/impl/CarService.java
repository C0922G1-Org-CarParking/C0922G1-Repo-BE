package com.example.service.impl;

import com.example.dto.ICarOfTicketDTO;
import com.example.model.Car;
import com.example.repository.ICarRepository;
import com.example.service.ICarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CarService implements ICarService {


    @Autowired
    private ICarRepository carRepository;


    /**
     * Created by: MinhCDK
     * Date created: 29/03/2023
     * Function: createCar
     *
     */

    public void createCar(String brand, String name, String plateNumber, Long carTypeId, Long customerId) {
        carRepository.createCar(brand, name, plateNumber, carTypeId, customerId);
    }

    @Override
    public List<ICarOfTicketDTO> findCarTicketByCustomerId(Long id) {
        return carRepository.findCarTicketByCustomerId(id);
    }


    @Override
    public List<Car> findCarById(Long id) {
        return this.carRepository.findByCarId(id);
    }

    @Override
    public void deleteCar(String plateNumber) {
        this.carRepository.deleteCarById(plateNumber);
    }

    @Override
    public List<Car> listCar(Long id) {
        return this.carRepository.findByCarId(id);
    }

//    @Override
//    public void createCar(String name, Long car_type_id, String brand,String plate_number, Long customer_id) {
//        this.carRepository.createCar(name, car_type_id,brand, plate_number, customer_id);
//    }

}
