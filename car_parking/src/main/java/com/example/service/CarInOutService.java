<<<<<<< HEAD:car_parking/src/main/java/com/example/service/CarInOutService.java
package com.example.service;

=======
package com.example.service.impl;
>>>>>>> origin/develop:car_parking/src/main/java/com/example/service/impl/CarInOutService.java
import com.example.dto.ICarInOutDTO;
import com.example.model.CarInOut;
import com.example.repository.ICarInOutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CarInOutService implements ICarInOutService {
    @Autowired

    private ICarInOutRepository iCarInOutRepository;

    @Override
    public void saveCarIn(CarInOut carIn) {
        iCarInOutRepository.saveCarIn(carIn.getCar().getId(), carIn.getTimeIn(), carIn.isParked(), carIn.getUrlCarInImage());
    }

    @Override
    public ICarInOutDTO searchCarInDto(String plateNumber) {
        return iCarInOutRepository.searchCarInDTOByScanning(plateNumber);
    }

    @Override
    public void saveCarOut(CarInOut carOut) {
        iCarInOutRepository.saveCarOut(carOut.getTimeOut(), carOut.getId(), carOut.isParked(), carOut.getUrlCarOutImage());
    }


    @Override
    public ICarInOutDTO searchCarOutDTO(String plateNumber) {
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
