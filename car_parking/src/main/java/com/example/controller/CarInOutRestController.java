package com.example.controller;

import com.example.dto.CarInOutDTO;
import com.example.dto.ICarInOutDTO;
import com.example.model.Car;
import com.example.model.CarInOut;
import com.example.service.ICarInOutService;
import net.sf.javaanpr.intelligence.Intelligence;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.xml.sax.SAXException;
import net.sf.javaanpr.imageanalysis.CarSnapshot;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/car-in-out")
public class CarInOutRestController {
    @Autowired
    private ICarInOutService iCarInOutService;

    /**
     * Created by: NamLQN
     * Date created: 29/03/2023
     * Function: find car information to display on view
     *
     * @param plateNumberImage input file image from user
     * @return Object CarInOutDTO or Http.Status Not_Found
     */
    @PostMapping(value = "/scanning-car-in",
            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Object> searchCarInDTOByScanning(@RequestParam(value = "plateNumberImage") MultipartFile plateNumberImage) throws IOException {

        InputStream plateNumberIS = null;
        try {
            plateNumberIS = plateNumberImage.getInputStream();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            Intelligence intelligence = new Intelligence();
            CarSnapshot carSnapshot = new CarSnapshot(plateNumberIS);
            String plateNumber = intelligence.recognize(carSnapshot);
            if (plateNumber == null) {
                return new ResponseEntity<>("Không scan được biển số", HttpStatus.NOT_ACCEPTABLE);
            }
            ICarInOutDTO carInDto = iCarInOutService.searchCarInDto(plateNumber);
            if (carInDto == null) {
                return new ResponseEntity<>("Không tìm thấy dữ liệu của biển số xe", HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(carInDto, HttpStatus.OK);
        } catch (ParserConfigurationException | IOException | SAXException e) {
            throw new RuntimeException();
        }
    }

    /**
     * Created by: NamLQN
     * Date created: 29/03/2023
     * Function: save Car history when getting in of the parking lot
     *
     * @param carInDTO from user with property timeIn
     * @return Http.status.NOT_FOUND or Http.status.OK
     */
    @PostMapping("/save-car-in")
    public ResponseEntity<Object> saveCarIn(@Validated @RequestBody CarInOutDTO carInDTO, BindingResult bindingResult) throws IOException {

        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.METHOD_NOT_ALLOWED);
        }

        if (carInDTO.getCarDTO().getId() == null) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        CarInOut carIn = new CarInOut();
        BeanUtils.copyProperties(carInDTO, carIn);
        Car car = new Car();
        car.setId(carInDTO.getCarDTO().getId());
        carIn.setCar(car);
        carIn.setParked(true);

        iCarInOutService.saveCarIn(carIn);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/scanning-car-out")
    public ResponseEntity<Object> searchCarOutDTOByScanning(@RequestParam(value = "plateNumberImage") MultipartFile plateNumberImage) {
        InputStream plateNumberIS = null;
        try {
            plateNumberIS = plateNumberImage.getInputStream();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            Intelligence intelligence = new Intelligence();
            CarSnapshot carSnapshot = new CarSnapshot(plateNumberIS);
            String plateNumber = intelligence.recognize(carSnapshot);
            if (plateNumber == null) {
                return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
            }
            ICarInOutDTO carOutDTO = iCarInOutService.searchCarOutDTO(plateNumber);
            if (carOutDTO == null) {
                return new ResponseEntity<>("Không tìm thấy dữ liệu hoặc vé đã hết hạn", HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(carOutDTO, HttpStatus.OK);
        } catch (ParserConfigurationException | IOException | SAXException e) {
            throw new RuntimeException();
        }
    }


    /**
     * Created by: NamLQN
     * Date created: 29/03/2023
     * Function: save car history when getting out of the parking lot
     *
     * @param carOutDTO from user with property timeOut
     * @return Http.status.NOT_FOUND or Http.status.OK
     */
    @PostMapping("/save-car-out")
    public ResponseEntity<Object> saveCarOut(@Validated @RequestBody CarInOutDTO carOutDTO, BindingResult bindingResult) {
//        new CarInOutDTO().validate(carOutDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(carOutDTO, HttpStatus.NOT_ACCEPTABLE);
        }
        CarInOut carOut = new CarInOut();
        BeanUtils.copyProperties(carOutDTO, carOut);
        carOut.setParked(false);
        iCarInOutService.saveCarOut(carOut);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ResponseStatus(
            value = HttpStatus.INTERNAL_SERVER_ERROR,
            reason = "Hệ thống đang bảo trì"
    )
    @ExceptionHandler(Exception.class)
    public void handleException(Exception e) {

    }
    @GetMapping("/list-car-in")
    public ResponseEntity<List<ICarInOutDTO>> searchCarInDtoByNameByCustomerNameByPhoneNumber(@RequestParam(defaultValue = "") String carPlateNumber,
                                                                                                 @RequestParam(defaultValue = "") String customerName,
                                                                                                 @RequestParam(defaultValue = "") String customerPhoneNumber) {
        List<ICarInOutDTO> carInDTOList = iCarInOutService.searchCarInDtoByNameByCustomerNameByPhoneNumber(carPlateNumber, customerName, customerPhoneNumber);
        if (carInDTOList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(carInDTOList, HttpStatus.OK);
    }

    @GetMapping("/list-car-out")
    public ResponseEntity<List<ICarInOutDTO>> searchCarOutDtoByNameByCustomerNameByPhoneNumber(@RequestParam(defaultValue = "") String carPlateNumber,
                                                                                                 @RequestParam(defaultValue = "") String customerName,
                                                                                                 @RequestParam(defaultValue = "") String customerPhoneNumber) {
        List<ICarInOutDTO> carOutDTOList = iCarInOutService.searchCarOutDTOByCustomerNameByPhoneNumberByPlateNumber(carPlateNumber, customerName, customerPhoneNumber);
        if (carOutDTOList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(carOutDTOList, HttpStatus.OK);
    }

}
