package com.example.repository;

import com.example.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;


@Transactional
public interface IAccountRepository extends JpaRepository<Account,Long> {

    Account findAccountByEmployee_Email(String username);
    
//    @Query(value = "SELECT username from account where username = ?1", nativeQuery = true)
//    String existsByEmployeeEmail(String username);

    @Modifying
    @Query(value = "update account set password =?1 where id =?2 ",nativeQuery = true)
    void saveNewPassword(String newPassword, Long id);
}
