package com.example.dto;

import com.example.model.Floor;
import com.example.model.Section;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class LocationDto implements Validator {

    private Long id;
    @Min(value = 0 , message = "không được nhập số âm")
    private Long name;
    private boolean isOccupied;
    @Min(value = 0 , message = "không được nhập số âm")
    @NotNull(message = "không được để trống")
    private Double width;
    @Min(value = 0 , message = "không được nhập số âm")
    @NotNull(message = "không được để trống")
    private Double height;
    @Min(value = 0 , message = "không được nhập số âm")
    @NotNull(message = "không được để trống")
    private Double length;
    private String permissionCarTypeLocations;
    private Section section;
    private Floor floor;

    private boolean isDeleted;

    public LocationDto() {
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

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public String getPermissionCarTypeLocations() {
        return permissionCarTypeLocations;
    }

    public void setPermissionCarTypeLocations(String permissionCarTypeLocations) {
        this.permissionCarTypeLocations = permissionCarTypeLocations;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public Floor getFloor() {
        return floor;
    }

    public void setFloor(Floor floor) {
        this.floor = floor;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
