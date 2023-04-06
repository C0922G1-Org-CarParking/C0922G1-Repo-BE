package com.example.dto;

import com.example.model.Car;
import com.example.model.Employee;
import com.example.model.Location;
import com.example.model.TicketType;

public interface ITicketDto {
    Long getTicketId();

    String getCustomerName();

    String getPlateNumber();

    String getPhoneNumber();

    String getEffectiveDate();

    String getExpiryDate();

    Long getFloorId();

    Long getSectionId();

    Long getLocationId();

    Long getTicketTypeId();

    String getTotalPrice();

    Double getRate();

}
