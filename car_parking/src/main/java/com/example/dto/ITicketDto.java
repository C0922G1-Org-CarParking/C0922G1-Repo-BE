package com.example.dto;

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
