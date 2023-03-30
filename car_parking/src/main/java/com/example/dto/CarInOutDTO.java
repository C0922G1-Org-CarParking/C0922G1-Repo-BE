package com.example.dto;

import com.example.model.Car;
import com.example.model.CarInOut;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class CarInOutDTO implements Validator {

    private Long id;


    private Car carDTO;

    @NotNull
    private String timeIn;

    private String timeOut;

    public CarInOutDTO() {
    }

    public CarInOutDTO(Long id, Car car, String timeIn, String timeOut) {
        this.id = id;
        this.carDTO = car;
        this.timeIn = timeIn;
        this.timeOut = timeOut;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Car getCarDTO() {
        return carDTO;
    }

    public void setCarDTO(Car carDTO) {
        this.carDTO = carDTO;
    }

    public String getTimeIn() {
        return timeIn;
    }

    public void setTimeIn(String timeIn) {
        this.timeIn = timeIn;
    }

    public String getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(String timeOut) {
        this.timeOut = timeOut;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        CarInOut carInOut = (CarInOut) target;
        LocalDateTime timeIn = LocalDateTime.parse(carInOut.getTimeIn());
        LocalDateTime timeOut = LocalDateTime.parse(carInOut.getTimeOut());
        if (timeIn.isBefore(LocalDateTime.now())){
            errors.rejectValue(carInOut.getTimeIn(),"errorTimeIn","Thời gian xe vào không hợp lệ");
        }
        if (timeOut.isBefore(timeIn)){
            errors.rejectValue(carInOut.getTimeOut(),"errorTimeOut","Thời gian xe ra không hợp lệ");
        }
    }
}
