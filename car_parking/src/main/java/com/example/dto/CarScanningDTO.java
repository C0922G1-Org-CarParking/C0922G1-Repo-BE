package com.example.dto;

import com.example.model.CarType;
import com.example.model.Customer;

public class CarScanningDTO {

    private Long id;

    private String name;

    private String plateNumber;

    private String brand;

    private boolean isDeleted;

    private CarType carType;

    private Customer customer;

    public CarScanningDTO() {
    }

    public CarScanningDTO(Long id, String name, String plateNumber, String brand, boolean isDeleted, CarType carType, Customer customer) {
        this.id = id;
        this.name = name;
        this.plateNumber = plateNumber;
        this.brand = brand;
        this.isDeleted = isDeleted;
        this.carType = carType;
        this.customer = customer;
    }

    public CarScanningDTO(long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
