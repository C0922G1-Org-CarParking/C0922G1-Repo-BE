package com.example.dto;

import com.example.model.Car;
import com.example.model.Customer;

import java.util.List;

public class CustomerCarDto {
    private Customer customer;
    private List<Car> cars;

    public CustomerCarDto() {
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public CustomerCarDto(Customer customer, List<Car> cars) {
        this.customer = customer;
        this.cars = cars;
    }
}
