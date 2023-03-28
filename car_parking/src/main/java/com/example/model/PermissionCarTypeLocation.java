package com.example.model;

import javax.persistence.*;

@Entity
public class PermissionCarTypeLocation {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "location_id", referencedColumnName = "id")
    private Location location;

    @ManyToOne
    @JoinColumn(name = "permission_car_type_id", referencedColumnName = "id")
    private PermissionCarType permissionCarType;

    public PermissionCarTypeLocation() {
    }

    public PermissionCarTypeLocation(long id, Location location, PermissionCarType permissionCarType) {
        this.id = id;
        this.location = location;
        this.permissionCarType = permissionCarType;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PermissionCarType getPermissionCarType() {
        return permissionCarType;
    }

    public void setPermissionCarType(PermissionCarType permissionCarType) {
        this.permissionCarType = permissionCarType;
    }
}
