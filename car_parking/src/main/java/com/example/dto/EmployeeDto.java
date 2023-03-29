package com.example.dto;


import com.example.model.Position;

import javax.validation.constraints.*;


public class EmployeeDto {
    private Long id;
    private String name;
    @Min(value = 16, message = "Tuổi của bạn phải lớn hơn hoặc bằng 16")
    private String dateOfBirth;
    private boolean gender;
    @NotBlank(message = "Nhập số điện thoại")
    @Pattern(regexp = "[0][1-9]{9}", message = "Số điện thoại phải có 10 số và bắt đầu bằng 0")
    private String phoneNumber;
    @Size(max = 12, message = "tên có độ dài tối đa 12 ký tự")
    @NotEmpty(message = "không được để trống")
    private String idCard;
    private int district;
    private int province;
    private int commune;
    @NotBlank(message = "Nhập địa chỉ")
    private String street;
    private Position position;
    @NotBlank(message = "Email ko được để trống")
    @Pattern(regexp = "^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "Email sai định dạng")
    private String email;
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
