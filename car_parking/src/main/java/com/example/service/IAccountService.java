package com.example.service;


import com.example.model.Account;

public interface IAccountService {
    Account findAccountByEmployee_Email(String username);

    void saveNewPassword(String newPassword,Long accountId);

}
