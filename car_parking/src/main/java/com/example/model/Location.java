package com.example.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Max;
import java.util.Set;

@Entity
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 45, nullable = false)

    private Long name;

    private boolean isOccupied;

    @Column(nullable = false)
    private double width;

    @Column(nullable = false)
    private double height;

    @Column(nullable = false)
    private double length;

    private String permissionCarTypeLocations;

    @ManyToOne
    @JoinColumn(name = "section_id", referencedColumnName = "id")
    private Section section;

    @ManyToOne
    @JoinColumn(name = "floor_id", referencedColumnName = "id")
    private Floor floor;

    @OneToMany(mappedBy = "location")
    @JsonIgnore
    private Set<Ticket> ticketSet;
    public Location() {
    }

    public Location(Long id, Long name, boolean isOccupied, double width, double height,
                    double length, String permissionCarTypeLocations, Section section, Floor floor, Set<Ticket> ticketSet, boolean isDeleted) {
        this.id = id;
        this.name = name;
        this.isOccupied = isOccupied;
        this.width = width;
        this.height = height;
        this.length = length;
        this.permissionCarTypeLocations = permissionCarTypeLocations;
        this.section = section;
        this.floor = floor;
        this.ticketSet = ticketSet;
        this.isDeleted = isDeleted;
    }


    public String getPermissionCarTypeLocations() {
        return permissionCarTypeLocations;
    }

    public void setPermissionCarTypeLocations(String permissionCarTypeLocations) {
        this.permissionCarTypeLocations = permissionCarTypeLocations;
    }

    private boolean isDeleted;

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

    public Long getName() {
        return name;
    }

    public void setName(Long name) {
        this.name = name;
    }


    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public Floor getFloor() {
        return floor;
    }

    public void setFloor(Floor floor) {
        this.floor = floor;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }



    public Set<Ticket> getTicketSet() {
        return ticketSet;
    }

    public void setTicketSet(Set<Ticket> ticketSet) {
        this.ticketSet = ticketSet;
    }


    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}


