package com.example.dto;

import com.example.model.Car;

import java.util.Set;

public interface CustomerDto {
    public Long getId();



    public String getName();



    public String getDateOfBirth();



    public String getIdCard() ;



    public String getPhoneNumber() ;



    public String getEmail() ;



    public boolean isGender() ;



    public int getDistrict() ;



    public int getProvince() ;



    public int getCommune() ;



    public String getStreet() ;



    public Set<Car> getCarSet() ;


}
