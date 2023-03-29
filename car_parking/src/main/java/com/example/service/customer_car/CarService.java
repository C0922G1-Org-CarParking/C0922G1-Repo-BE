package com.example.service.customer_car;

import com.example.model.Car;
import com.example.repository.customer_car.ICarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CarService implements ICarService {
    @Autowired
    private ICarRepository carRepository;

    @Override
    public void deleteCar(Long id) {
        this.carRepository.deleteCarById(id);
    }

    @Override
    public List<Car> listCar(Long id) {
        return this.carRepository.findByCarId(id);
    }

    @Override
    public void createCar(String name, Long car_type_id, String brand,String plate_number, Long customer_id) {
        this.carRepository.createCar(name, car_type_id,brand, plate_number, customer_id);
    }

}
