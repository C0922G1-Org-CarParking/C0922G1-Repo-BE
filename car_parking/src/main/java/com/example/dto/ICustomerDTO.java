package com.example.dto;

import java.sql.Date;

public interface ICustomerDTO {
    /**
     * Created by: VuBD
     * Date created: 29/03/2023
     *
     * @return
     */
//    Long getId();
//
//    String getName();
//
//    Date getDateOfBirth();
//
//    String getIdCard();
//
//    boolean isGender();
//
//    String getPhoneNumber();
//
//    String getEmail();


    String getName();
    Long getId();
    String getIdCard();
    boolean getIsGender();
    String getDateOfBirth();
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
