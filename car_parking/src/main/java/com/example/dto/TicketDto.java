package com.example.dto;

public interface TicketDto {
    Integer getTicketId();
    String getPlateNumber();
    String getCustomerName();
    String getCustomerPhoneNumber();
    String getEmployeeName();
    String getEmployeePhoneNumber();
    String getTicketType();
    String getTotalPrice();
    Integer getFloor();
    String getExpiryDate();
}
