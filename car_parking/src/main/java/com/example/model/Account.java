package com.example.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Account {
    @Id
    @Column(length = 45,nullable = false,unique = true)
    private String employeeEmail;

    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy = "account")
    @JsonIgnore
    private Set<AccountRole> accountRoleSet;

    @OneToOne(mappedBy = "account")
    private Employee employee;

    public Account() {
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<AccountRole> getAccountRoleSet() {
        return accountRoleSet;
    }

    public void setAccountRoleSet(Set<AccountRole> accountRoleSet) {
        this.accountRoleSet = accountRoleSet;
    }
}
