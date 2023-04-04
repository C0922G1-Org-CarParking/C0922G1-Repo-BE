package com.example.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;


@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 45,nullable = false)
    private String name;

    @Column(length = 45,nullable = false, unique = true)
    private String plateNumber;


    @Column(length = 45,nullable = false)
    private String brand;

    private boolean isDeleted;

    @ManyToOne
    @JoinColumn(name = "car_type_id",referencedColumnName = "id")
    private CarType carType;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;


    @OneToMany(mappedBy = "car")
    @JsonIgnore
    private Set<CarInOut> carInOutSet;

    @OneToMany(mappedBy = "car")
    @JsonIgnore
    private Set<Ticket> ticketSet;



    public Car(Long id, String name, String plateNumber, String brand, boolean isDeleted, CarType carType, Customer customer, Set<CarInOut> carInOutSet, Set<Ticket> ticketSet) {
        this.id = id;
        this.name = name;
        this.plateNumber = plateNumber;
        this.brand = brand;
        this.isDeleted = isDeleted;
        this.carType = carType;
        this.customer = customer;
        this.carInOutSet = carInOutSet;
        this.ticketSet = ticketSet;
    }



    public Car(long id) {
        this.id = id;
    }


    public Car() {


    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Set<CarInOut> getCarInOutSet() {
        return carInOutSet;
    }

    public void setCarInOutSet(Set<CarInOut> carInOutSet) {
        this.carInOutSet = carInOutSet;
    }

    public Set<Ticket> getTicketSet() {
        return ticketSet;
    }

    public void setTicketSet(Set<Ticket> ticketSet) {
        this.ticketSet = ticketSet;
    }

}
