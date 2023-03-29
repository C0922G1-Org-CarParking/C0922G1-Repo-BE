package com.example.repository;

import com.example.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;


@Transactional
public interface IAccountRepository extends JpaRepository<Account, String> {

    Account findAccountByEmployeeEmail(String username);
    
    @Query(value = "SELECT username from account where username = ?1", nativeQuery = true)
    String existsByEmployeeEmail(String username);

    @Modifying
    @Query(value = "update account set encrypt_pw =?1 where verification_code=?2 ",nativeQuery = true)
    void saveNewPassword(String password, String code);
}
