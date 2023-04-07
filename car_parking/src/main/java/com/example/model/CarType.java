package com.example.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
public class CarType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 45,nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private double rate;


    public CarType(Long id, String name, double rate, Set<Car> carSet) {
        this.id = id;
        this.name = name;
        this.rate = rate;
        this.carSet = carSet;
    }


    @OneToMany(mappedBy = "carType")
    @JsonIgnore
    private Set<Car> carSet;

    public CarType() {
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

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public Set<Car> getCarSet() {
        return carSet;
    }

    public void setCarSet(Set<Car> carSet) {
        this.carSet = carSet;
    }

}
