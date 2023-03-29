package com.example.dto;

import com.example.model.Car;
import com.example.model.Employee;
import com.example.model.Location;
import com.example.model.TicketType;

public interface ITicketDto {



    public Long getId();

    public String getEffectiveDate();

    public String getExpiryDate();

    public double getTotalPrice();

    public TicketType getTicketType();

    public Car getCar();

    public Employee getEmployee();

    public Location getLocation();

}
