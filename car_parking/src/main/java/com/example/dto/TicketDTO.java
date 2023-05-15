package com.example.dto;

import com.example.model.*;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TicketDTO implements Validator {
    @NotBlank(message = "Không được để trống")
    private String effectiveDate;
    @NotBlank(message = "Không được để trống")
    private String expiryDate;
    @NotNull(message = "Không được để trống")
    private TicketType ticketType;
    @NotNull(message = "Không được để trống")
    private Car car;

    @NotNull(message = "Không được để trống")
    @Min(value = 0 , message = "Nhỏ nhất là 0")
    private Double totalPrice;
    @NotNull(message = "Không được để trống")
    private Location location;
    private boolean isDeleted = false;
    @NotNull(message = "Không được để trống")
    @Min(value = 0 , message = "Nhỏ nhất là 0")
    private Double price;
    @NotNull(message = "Không được để trống")
    private Employee employee;

    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public String getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public TicketType getTicketType() {
        return ticketType;
    }

    public void setTicketType(TicketType ticketType) {
        this.ticketType = ticketType;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        TicketDTO ticket = (TicketDTO) target;

        // Kiểm tra xem Ngày hiệu lực có đúng định dạng và không rỗng
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "effectiveDate", "field.required");
        if (!errors.hasFieldErrors("effectiveDate")) {
            try {
                LocalDate.parse(ticket.getEffectiveDate(), DATE_FORMAT);
            } catch (Exception e) {
                errors.rejectValue("effectiveDate", "date.format", new Object[] { "yyyy-MM-dd" }, null);
            }
        }

        // Kiểm tra xem Ngày hết hạn có đúng định dạng và không rỗng
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "expiryDate", "field.required");
        if (!errors.hasFieldErrors("expiryDate")) {
            try {
                LocalDate.parse(ticket.getExpiryDate(), DATE_FORMAT);
            } catch (Exception e) {
                errors.rejectValue("expiryDate", "date.format", new Object[] { "yyyy-MM-dd" }, null);
            }
        }

        // Kiểm tra xem Ngày hiệu lực có lớn hơn Ngày hết hạn không
        if (!errors.hasFieldErrors("effectiveDate") && !errors.hasFieldErrors("expiryDate")) {
            LocalDate effectiveDate = LocalDate.parse(ticket.getEffectiveDate(), DATE_FORMAT);
            LocalDate expiryDate = LocalDate.parse(ticket.getExpiryDate(), DATE_FORMAT);
            if (effectiveDate.isAfter(expiryDate)) {
                errors.rejectValue("effectiveDate", "date.invalid", null, null);
            }
        }
    }
}