package com.example.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 45, nullable = false)
    private String name;

    @Column(columnDefinition = "date", nullable = false)
    private String dateOfBirth;

    @Column(nullable = false)
    private boolean gender;


    @Column(length = 45,nullable = false,unique = true)
    private String email;


    @Column(length = 45, nullable = false, unique = true)
    private String idCard;

    @Column(nullable = false)
    private int district;
    @Column(nullable = false)
    private int province;
    @Column(nullable = false)
    private int commune;
    @Column(nullable = false)
    private String street;

    private boolean isDeleted;
    @Column(length = 20, nullable = false, unique = true)
    private String phoneNumber;


    @OneToOne(mappedBy = "employee")
    private Account account;

    @ManyToOne
    @JoinColumn(name = "position_id", referencedColumnName = "id")
    private Position position;

    @OneToMany(mappedBy = "employee")
    @JsonIgnore
    private Set<Ticket> ticketSet;

    public Employee(Long id, String name, String dateOfBirth, boolean gender, String email, String idCard, int district, int province, int commune, String street,
                    boolean isDeleted, String phoneNumber, Account account, Position position, Set<Ticket> ticketSet) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.email = email;
        this.idCard = idCard;
        this.district = district;
        this.province = province;
        this.commune = commune;
        this.street = street;
        this.isDeleted = isDeleted;
        this.phoneNumber = phoneNumber;
        this.account = account;
        this.position = position;
        this.ticketSet = ticketSet;
    }

    public Employee() {
    }


    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public int getDistrict() {
        return district;
    }

    public void setDistrict(int district) {
        this.district = district;
    }

    public int getProvince() {
        return province;
    }

    public void setProvince(int province) {
        this.province = province;
    }

    public int getCommune() {
        return commune;
    }

    public void setCommune(int commune) {
        this.commune = commune;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Set<Ticket> getTicketSet() {
        return ticketSet;
    }

    public void setTicketSet(Set<Ticket> ticketSet) {
        this.ticketSet = ticketSet;
    }
}
