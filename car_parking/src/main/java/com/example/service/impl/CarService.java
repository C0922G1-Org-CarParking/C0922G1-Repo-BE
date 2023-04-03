package com.example.service.impl;

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
     * Create by: VuTN,
     * Date create : 29/03/2023
     * Function find car by id
     * @Param id
     */
    @Override
    public List<Car> findCarById(Long id) {
        return this.carRepository.findByCarId(id);
    }
    /**
     * Create by: VuTN,
     * Date create : 29/03/2023
     * Function delete car by plateNumber
     * @Param plateNumber
     */
    @Override
    public void deleteCar(String plateNumber) {
        this.carRepository.deleteCarById(plateNumber);
    }
    /**
     * Create by: VuTN,
     * Date create : 29/03/2023
     * Function find car by id
     * @Param id
     */
    @Override
    public List<Car> listCar(Long id) {
        return this.carRepository.findByCarId(id);
    }
    /**
     * Create by: VuTN,
     * Date create : 29/03/2023
     * function create car
     */
    @Override
    public void createCar(String name, Long car_type_id, String brand,String plate_number, Long customer_id) {
        this.carRepository.createCar(name, car_type_id,brand, plate_number, customer_id);
    }

}
