package com.example.dto;

import java.sql.Date;

public interface ICustomerDTO {
    /**
     * Created by: VuBD
     * Date created: 29/03/2023
     *
     * @return
     */
    int getId();

    String getName();

    Date getDateOfBirth();

    String getIdCard();

    boolean isGender();

    String getPhoneNumber();

    String getEmail();
}
