package com.example.dto;

public interface ICustomerDTO {
    /**
     * Created by: VuBD
     * Date created: 29/03/2023
     *
     * @return
     */



    Long getId();
    String getName();
    String getDateOfBirth();
    String getIdCard();
    boolean isGender();
    String getPhoneNumber();
    String getEmail();
    String getStreet();
    Long getCarId();
    Long getCarTypeId();
    String getCarName();
    String getPlateNumber();
    Long getTicketTypeId();
    String getExpiryDate();
    int getCommune();
    int getDistrict();
    int getProvince();
}
