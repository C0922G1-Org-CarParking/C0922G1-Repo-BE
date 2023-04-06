package com.example.service.impl;

import com.example.model.Account;
import com.example.repository.IAccountRepository;
import com.example.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class AccountService implements IAccountService {
    /**
     * HoangNM
     */
    @Autowired
    IAccountRepository accountRepository;

    /**
     * HoangNM
     */
    @Override
    public Account findAccountByEmployeeEmail(String username) {
        return accountRepository.findAccountByEmployeeEmail(username);
    }

    /**
     * HoangNM
     */
    @Override
    public void saveNewPassword(String newPassword,Long accountId) {
        accountRepository.saveNewPassword(BCrypt.hashpw(newPassword, BCrypt.gensalt(12)),accountId);
    }

    /**
     * HoangNM
     */
    @Override
    public boolean checkPassword(String password, String oldPassword) {
        return BCrypt.checkpw(password,oldPassword);
    }


}
