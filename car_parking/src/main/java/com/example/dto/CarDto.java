package com.example.dto;

import com.example.model.CarInOut;
import com.example.model.CarType;
import com.example.model.Customer;
import com.example.model.Ticket;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Set;

public class CarDto {
private Long id;

//    @NotBlank(message = "Vui lòng nhập vào đây")
//    @Size(max = 20 ,message = "Tên không được quá 20 ký tự")
//    @Pattern(regexp = "^[a-zA-z0-9]+$", message = "Tên không được nhập số và ký tự đặc biệt.")

    private String name;


//        @NotBlank(message = "Vui lòng nhập vào đây")
    private String plateNumber;

//    @NotBlank(message = "Vui lòng nhập vào đây")
//    @Size(max = 20 ,message = "Tên không được quá 20 ký tự")
//    @Pattern(regexp = "[a-zA-z0-9 ]+", message = "Tên không được nhập số và ký tự đặc biệt.")
    private String brand;



    private CarType carType;


    private Customer customer;

    private boolean isParked;
//    private Set<CarInOut> carInOutSet;
//
//
//    private Set<Ticket> ticketSet;

    public CarDto() {
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

//    public Set<CarInOut> getCarInOutSet() {
//        return carInOutSet;
//    }
//
//    public void setCarInOutSet(Set<CarInOut> carInOutSet) {
//        this.carInOutSet = carInOutSet;
//    }
//
//    public Set<Ticket> getTicketSet() {
//        return ticketSet;
//    }
//
//    public void setTicketSet(Set<Ticket> ticketSet) {
//        this.ticketSet = ticketSet;
//    }

    }

