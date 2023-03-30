package com.example.controller.car_in_out;

import com.example.dto.CarInOutDTO;
import com.example.dto.ICarInOutDTO;
import com.example.model.Car;
import com.example.model.CarInOut;
import com.example.service.car_in_out.ICarInOutService;
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

@RestController
@CrossOrigin
@RequestMapping("/car-in-out")
public class CarInOutController {
    @Autowired
    private ICarInOutService carInOutService;

    /*
     * Created by: NamLQN
     * Date created: 29/03/2023
     * Function: find car information to display on view
     * @param plateNumberImage input file image from user
     * @return Object CarInOutDTO or Http.status Not_Found
     */
    @PostMapping(value = "/scanning-car",
            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Object> searchCarInOutDTO(@RequestParam(value = "plateNumberImage") MultipartFile plateNumberImage) {

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

            if (carInOutService.searchCarInOutDTO(plateNumber) == null) {
                return new ResponseEntity<>("Không tìm thấy dữ liệu", HttpStatus.NOT_FOUND);
            }

            ICarInOutDTO carInOutDTO = carInOutService.searchCarInOutDTO(plateNumber);
            return new ResponseEntity<>(carInOutDTO, HttpStatus.OK);
        } catch (ParserConfigurationException | IOException | SAXException e) {
            throw new RuntimeException();
        }
    }

    /**
     * Created by: NamLQN
     * Date created: 29/03/2023
     * Function: save Car history when getting in and out of the parking lot
     *
     * @param carInOutDTO from user with properties timeIn and timeOut
     * @return Http.status.NOT_FOUND or Http.status.OK
     */
    @PostMapping("/save-car-in-out")
    public ResponseEntity<Object> saveCarInOut(@Validated @RequestBody CarInOutDTO carInOutDTO, BindingResult bindingResult) {

        new CarInOutDTO().validate(carInOutDTO, bindingResult);

        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(carInOutDTO, HttpStatus.BAD_REQUEST);
        }
        if (carInOutDTO == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        CarInOut carInOut = new CarInOut();
        BeanUtils.copyProperties(carInOutDTO, carInOut);
        Car car = new Car();
        car.setId(carInOut.getId());
        carInOut.setCar(car);
        carInOutService.saveCarInOut(carInOut);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ResponseStatus(
            value = HttpStatus.NOT_FOUND,
            reason = "không xác định được file"
    )
    @ExceptionHandler(Exception.class)
    public void handleException(Exception e){
    }

}
