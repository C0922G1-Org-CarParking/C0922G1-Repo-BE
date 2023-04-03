package com.example.service;


import com.example.model.Account;

public interface IAccountService {
    Account findAccountByEmployeeEmail(String username);

    void saveNewPassword(String newPassword,Long accountId);

}
