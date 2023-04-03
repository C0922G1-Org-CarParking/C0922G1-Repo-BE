package com.example.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Floor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 45,nullable = false,unique = true)
    private String nameFloor;


    @OneToMany(mappedBy = "floor")
    @JsonIgnore
    private Set<Location> locationSet;

    public Set<Location> getLocationSet() {
        return locationSet;
    }

    public void setLocationSet(Set<Location> locationSet) {
        this.locationSet = locationSet;
    }

    public Floor() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameFloor() {
        return nameFloor;
    }

    public void setNameFloor(String nameFloor) {
        this.nameFloor = nameFloor;
    }
}
