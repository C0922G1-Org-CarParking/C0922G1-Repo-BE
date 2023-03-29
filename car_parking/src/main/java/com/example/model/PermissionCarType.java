package com.example.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
public class PermissionCarType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    @OneToMany(mappedBy = "permissionCarType")
    @JsonIgnore
    private Set<PermissionCarTypeLocation> permissionCarTypeLocations;


    public PermissionCarType() {
    }

    public Set<PermissionCarTypeLocation> getPermissionCarTypeLocations() {
        return permissionCarTypeLocations;
    }

    public void setPermissionCarTypeLocations(Set<PermissionCarTypeLocation> permissionCarTypeLocations) {
        this.permissionCarTypeLocations = permissionCarTypeLocations;
    }

    public PermissionCarType(long id, String name, Set<PermissionCarType> permissionCarTypes) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
