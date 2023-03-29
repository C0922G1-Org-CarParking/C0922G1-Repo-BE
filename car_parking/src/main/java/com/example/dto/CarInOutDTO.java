package com.example.dto;

import com.example.model.Car;
import com.example.model.CarInOut;
import net.bytebuddy.asm.Advice;
import org.springframework.boot.autoconfigure.web.format.DateTimeFormatters;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotNull;
import java.sql.Time;
import java.text.Format;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Formatter;

public class CarInOutDTO implements Validator {

    private Long id;


    private Car car;

    @NotNull
    private String timeIn;

    private String timeOut;

    public CarInOutDTO() {
    }

    public CarInOutDTO(Long id, Car car, String timeIn, String timeOut) {
        this.id = id;
        this.car = car;
        this.timeIn = timeIn;
        this.timeOut = timeOut;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
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
