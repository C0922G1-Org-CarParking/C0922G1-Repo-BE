package com.example.dto;

import com.example.model.Car;
import com.example.model.CarInOut;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class CarInOutDTO implements Validator {

    private Long id;

    private CarDTO carDTO;

    @NotNull
    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}(\\.\\d{2})?$")
    private String timeIn;

    @Size(min = 10, max = 23)
    private String timeOut;

    public CarInOutDTO() {
    }

    public CarInOutDTO(Long id, CarDTO carDTO, String timeIn, String timeOut) {
        this.id = id;
        this.carDTO = carDTO;
        this.timeIn = timeIn;
        this.timeOut = timeOut;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CarDTO getCarDTO() {
        return carDTO;
    }

    public void setCarDTO(CarDTO carDTO) {
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
        CarInOutDTO carInOutDTO = (CarInOutDTO) target;
        LocalDateTime timeIn = LocalDateTime.parse(carInOutDTO.getTimeIn());
        if (carInOutDTO.getTimeOut() != null) {
            LocalDateTime timeOut = LocalDateTime.parse(carInOutDTO.getTimeOut());
            if (timeOut.isBefore(timeIn)) {
                errors.rejectValue(carInOutDTO.getTimeOut(), "errorTimeOut", "Thời gian xe ra không hợp lệ");
            }
        }

    }
}
