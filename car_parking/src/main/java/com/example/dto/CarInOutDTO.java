package com.example.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class CarInOutDTO implements Validator {

    private Long id;

    private CarScanningDTO carScanningDTO;

    private String timeIn;

    private String timeOut;

    private String urlCarInImage;

    private String urlCarOutImage;

    public String getUrlCarInImage() {
        return urlCarInImage;
    }

    public void setUrlCarInImage(String urlCarInImage) {
        this.urlCarInImage = urlCarInImage;
    }

    public CarInOutDTO() {
    }

    public CarInOutDTO(Long id, CarScanningDTO carScanningDTO, String timeIn, String timeOut, String urlCarInImage, String urlCarOutImage) {
        this.id = id;
        this.carScanningDTO = carScanningDTO;
        this.timeIn = timeIn;
        this.timeOut = timeOut;
        this.urlCarInImage = urlCarInImage;
        this.urlCarOutImage = urlCarOutImage;
    }

    public String getUrlCarOutImage() {
        return urlCarOutImage;
    }

    public void setUrlCarOutImage(String urlCarOutImage) {
        this.urlCarOutImage = urlCarOutImage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CarScanningDTO getCarDTO() {
        return carScanningDTO;
    }

    public void setCarDTO(CarScanningDTO carScanningDTO) {
        this.carScanningDTO = carScanningDTO;
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
//        CarInOutDTO carInOutDTO = (CarInOutDTO) target;
//        LocalDateTime timeIn = carInOutDTO.getTimeIn();
//        if (carInOutDTO.getTimeOut() != null) {
//            LocalDateTime timeOut = LocalDateTime.parse(carInOutDTO.getTimeOut());
//            if (timeOut.isBefore(timeIn)) {
//                errors.rejectValue(carInOutDTO.getTimeOut(), "errorTimeOut", "Thời gian xe ra không hợp lệ");
//            }
//        }
    }
}
