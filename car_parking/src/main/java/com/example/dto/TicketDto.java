package com.example.dto;


import com.example.model.Car;
import com.example.model.Employee;
import com.example.model.Location;
import com.example.model.TicketType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;

public class TicketDto implements Validator {
    private String effectiveDate;
//    @NotBlank(message = "Không được để trống")
//    @Size(max = 20,min = 2 , message = "Dài nhất 12 kí tự , ít nhất 2 kí tự ")
    private String expiryDate;
    @NotNull(message = "Không được để trống")
    private TicketType ticketType;
    @NotNull(message = "Không được để trống")
    private Car car;

    @NotNull(message = "Không được để trống")
    @Min(value = 0 , message = "Nhỏ nhất là 0")
    private Double totalPrice;
    @NotNull(message = "Không được để trống")
    private Location location;
    private boolean isDeleted = false;
    @NotNull(message = "Không được để trống")
    @Min(value = 0 , message = "Nhỏ nhất là 0")
    private Double price;
    @NotNull(message = "Không được để trống")
    private Employee employee;

    public String getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public TicketType getTicketType() {
        return ticketType;
    }

    public void setTicketType(TicketType ticketType) {
        this.ticketType = ticketType;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
