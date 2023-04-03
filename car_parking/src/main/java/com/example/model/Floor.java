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
    private String name;

    public Floor(Long id, String name, Set<Location> locationSet) {
        this.id = id;
        this.name = name;
        this.locationSet = locationSet;
    }

    @OneToMany(mappedBy = "floor")
    @JsonIgnore
    private Set<Location> locationSet;

    public Floor() {

    }

    public Floor(Long id) {
        this.id = id;
    }

    public Set<Location> getLocationSet() {
        return locationSet;
    }

    public void setLocationSet(Set<Location> locationSet) {
        this.locationSet = locationSet;
    }

    public Floor(long id) {
        this.id = id;
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

    public void setName(String nameFloor) {
        this.name = name;
    }

}

