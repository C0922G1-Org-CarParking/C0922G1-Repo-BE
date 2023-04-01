package com.example.dto;


import com.example.model.Position;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


import javax.validation.constraints.*;



public class EmployeeDto implements Validator {
    private Long id;
    @Size(max = 100, message = "Tên nhà cung cấp không được quá 30 ký tự.")
    @NotBlank(message = "tên nhân viên không được để trống")
//    @Pattern(regexp = "^[A-Za-z]+(?:\\s+[A-Za-z]+)*$",message = "Tên khách hàng không thể chứa ký tự đặc biệt và không thể chứa số")
    private String name;
    @NotBlank(message = "Nhập ngày sinh")
    private String dateOfBirth;
    private boolean gender;
    @NotBlank(message = "Không được để trống.")
//    @Pattern(regexp = "^(0|\\+84)\\d{9}$", message = "Số điện thoại không đúng định dạng (Ví dụ: +84937110xxx / 0937110xxx).")
    private String phoneNumber;
    @NotBlank(message = "số cmnd không được để trống")
//    @Pattern(regexp = "(\\d{9})|(\\d{12})",message = "số cmnd phải đúng định dạng,vd:XXXXXXXXX hoặc XXXXXXXXXXXX (X là số 0-9).")
    private String idCard;
    @Min(value = 1)
    private int district;
    @Min(value = 1)
    @Max(value = 63)
    private int province;
    @Min(value = 1)
    private int commune;
    @Size(max = 200, message = "Địa chỉ không được quá 200 ký tự.")
    @NotBlank(message = "Không được để trống.")
    private String street;
    private Position position;
    @NotBlank(message = "Không được để trống.")
//    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "Email không đúng định dạng (Ví dụ: employee-email@email.com).")
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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
