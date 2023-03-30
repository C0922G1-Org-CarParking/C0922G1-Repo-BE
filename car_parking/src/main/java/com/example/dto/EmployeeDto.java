package com.example.dto;


import com.example.model.Position;

import javax.persistence.Column;
import javax.validation.constraints.*;


public class EmployeeDto {
    private Long id;
    @NotBlank(message = "tên khách hàng không được để trống")
    @Pattern(regexp = "^([\\p{Lu}][\\p{Ll}]{1,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){0,5}$",message = "Tên khách hàng không thể chứa ký tự đặc biệt và không thể chứa số")
    private String name;
    @Min(value = 16, message = "Tuổi của bạn phải lớn hơn hoặc bằng 16")
    private String dateOfBirth;
    private boolean gender;
    @Pattern(regexp = "(090\\d{7})|(091\\d{7})|(\\(84\\)\\+90\\d{7})|(\\(84\\)\\+91\\d{7})",message = "Số điện thoại phải đúng định dạng, vd:090xxxxxxx; 091xxxxxxx; (84)+90xxxxxxx; (84)+91xxxxxxx " )
    @NotBlank(message = "số điện thoại không được để trống")
    private String phoneNumber;
    @NotBlank(message = "số cmnd không được để trống")
    @Pattern(regexp = "(\\d{9})|(\\d{12})",message = "số cmnd phải đúng định dạng,vd:XXXXXXXXX hoặc XXXXXXXXXXXX (X là số 0-9).")
    private String idCard;
    private int district;
    private int province;
    private int commune;
    @NotBlank(message = "Nhập địa chỉ")
    private String street;
    private Position position;
    @NotBlank(message = "email không được để trống")
    @Pattern(regexp = "[a-zA-Z]+\\w+@\\w+(\\.\\w+)+", message = "email phải đúng định dạng, vd: abc123@gmail.com")
    private String email;

    @Column(columnDefinition = "boolean default false")
    private boolean isDeleted;

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

    public EmployeeDto() {
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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
}
