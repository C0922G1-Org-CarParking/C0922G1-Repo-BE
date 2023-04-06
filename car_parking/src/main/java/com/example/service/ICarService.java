package com.example.service;

import com.example.dto.ICarTicketDTO;
import com.example.model.Car;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICarService {

    /**
     * Created by: MinhCDK
     * Date created: 29/03/2023
     * Function: createCar
     *
     */

    void createCar(String brand, String name, String plateNumber, Long carTypeId, Long customerId);

    /**
     * Created by: MinhCDK
     * Date created: 29/03/2023
     * Function: infoCar
     *
     * @Param: customerId
     * Return: infoCustomer and listCar
     */

//    List<ICarDto> findCarById(Long id);

    List<ICarTicketDTO> findCarTicketByCustomerId(Long id);

    /**
     * Create by: VuTN,
     * Date create : 29/03/2023
     * Function find car by id
     * @Param id
     */
    List<Car>findCarById(Long id);
    /**
     * Create by: VuTN,
     * Date create : 29/03/2023
     * Function delete car by plateNumber
     * @Param plateNumber
     */
    void deleteCar(String plateNumber);
    /**
     * Create by: VuTN,
     * Date create : 29/03/2023
     * Function find car by id
     * @Param id
     */
    List<Car> listCar(Long id);
    /**
     * Create by: VuTN,
     * Date create : 29/03/2023
     * function create car
     */
//    void createCar(String name,Long car_type_id,String plate_number,Long customer_id);
}
