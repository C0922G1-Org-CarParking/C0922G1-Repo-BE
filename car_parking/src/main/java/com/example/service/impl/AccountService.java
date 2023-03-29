package com.example.service.impl;

import com.example.repository.IAccountRepository;
import com.example.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService implements IAccountService {
    @Autowired
    IAccountRepository accountRepository;

//    @Override
//    public String existsByUserName(String username) {
//        return accountRepository.existsByEmployeeEmail(username);
//    }
//
//    @Override
//    public void saveNewPassword(String password,String code) {
//        accountRepository.saveNewPassword(password,code);
//    }




}
