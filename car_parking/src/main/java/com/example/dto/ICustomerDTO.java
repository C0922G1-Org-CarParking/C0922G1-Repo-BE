package com.example.dto;

import java.sql.Date;

public interface ICustomerDTO {
    /**
     * Created by: VuBD
     * Date created: 29/03/2023
     * @return
     */
    int getId();
String getName();
Date getDate_of_birth();
String getId_card();
boolean isGender();
String getPhone_number();
String getEmail();
}
