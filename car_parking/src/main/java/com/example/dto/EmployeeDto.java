package com.example.dto;

import com.example.model.Account;
import com.example.model.Position;
import com.example.model.Ticket;

import java.util.Set;

public class EmployeeDto {
    private Long id;
    private String name;
    private String dateOfBirth;
    private boolean gender;
    private Account account;
    private String idCard;
    private int district;
    private int province;
    private int commune;
    private String street;
    private boolean isDeleted;
    private Position position;
    private Set<Ticket> ticketSet;

}
