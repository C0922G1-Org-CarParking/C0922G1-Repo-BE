package com.example.dto;

import java.sql.Date;

public interface ICustomerDTO {
int getId();
String getName();
Date getDate_of_birth();
String getId_card();
boolean isGender();
String getPhone_number();
String getEmail();
}
