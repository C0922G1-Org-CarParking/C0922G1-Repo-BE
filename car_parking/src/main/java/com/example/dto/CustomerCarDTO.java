package com.example.dto;


import javax.validation.Valid;
import java.util.List;

public class CustomerCarDTO {

    private Long id;
//    @NotBlank(message = "Vui lòng nhập vào đây")
    private String name;
//    @NotBlank(message = "Vui lòng nhập vào đây")

    private String dateOfBirth;

//    @NotBlank(message = "Vui lòng nhập vào đây")
//    @Pattern(regexp = "^(\\d{9}|\\d{12
//    })| *$",
//            message = "Số CCCD phải đúng định dạng XXXXXXXXX hoặc XXXXXXXXXXXX (X là số 0-9).")
    private String idCard;
//    @Pattern(message = "Số điện thoại không đúng định dạng.", regexp = "^(((\\\\+|)84)|0)(3|5|7|8|9)+([0-9]{8})$")
//    @NotBlank(message = "Vui lòng nhập vào đây")
    private String phoneNumber;

//    @NotBlank(message = "Vui lòng nhập vào đây")
//    @Pattern(message = "Email không đúng định dạng.", regexp = "[\\w]+[@][\\w]+.[\\w]+")
    private String email;
    private boolean gender;


    private int district;

    private int province;

    private int commune;
//    @NotBlank(message = "Vui lòng nhập vào đây")
    private String street;

    private boolean isDeleted;

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }
    @Valid
    private List<CarDTO> carList;

    public CustomerCarDTO() {
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

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
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

    public List<CarDTO> getCarList() {
        return carList;
    }

    public void setCarList(List<CarDTO> carList) {
        this.carList = carList;
    }
}
