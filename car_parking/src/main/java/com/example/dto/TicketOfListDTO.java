package com.example.dto;

public interface TicketOfListDTO {
    Integer getTicketId();
    String getPlateNumber();
    String getCustomerName();
    String getCustomerCode();
    String getCustomerPhoneNumber();
    String getEmployeeName();
    String getEmployeeCode();
    String getEmployeePhoneNumber();
    String getTicketType();
    Double getTotalPrice();
    Integer getFloor();
    String getSection();
    Integer getLocation();
    String getEffectiveDate();
    String getExpiryDate();
}
