package com.example.service;


public interface IAccountService {


    String existsByUserName(String username);

    void saveNewPassword(String password,String code);

}
