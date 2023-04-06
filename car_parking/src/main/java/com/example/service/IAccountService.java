package com.example.service;


import com.example.model.Account;

public interface IAccountService {
    /**
     * HoangNM
     */
    Account findAccountByEmployeeEmail(String username);

    /**
     * HoangNM
     */
    void saveNewPassword(String newPassword,Long accountId);

    /**
     * HoangNM
     */
    boolean checkPassword(String password, String oldPassword);
}
