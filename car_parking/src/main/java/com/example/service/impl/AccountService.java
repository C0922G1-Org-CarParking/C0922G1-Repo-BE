package com.example.service.impl;

import com.example.model.Account;
import com.example.repository.IAccountRepository;
import com.example.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class AccountService implements IAccountService {
    @Autowired
    IAccountRepository accountRepository;

    @Override
    public Account findAccountByEmployeeEmail(String username) {
        return accountRepository.findAccountByEmployeeEmail(username);
    }

    @Override
    public void saveNewPassword(String newPassword,Long accountId) {
        accountRepository.saveNewPassword(BCrypt.hashpw(newPassword, BCrypt.gensalt(12)),accountId);
    }

}
