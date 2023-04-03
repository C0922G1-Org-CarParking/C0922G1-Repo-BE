package com.example.model;


import javax.persistence.*;

@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, columnDefinition = "date")
    private String effectiveDate;
    @Column(nullable = false, columnDefinition = "date")
    private String expiryDate;

    private Double totalPrice;
    @Column(nullable = false)
    private Double price;

    public Ticket(Long id, String effectiveDate, String expiryDate, double totalPrice, double price, TicketType ticketType, Car car, Employee employee, Location location, boolean isDeleted) {
        this.id = id;
        this.effectiveDate = effectiveDate;
        this.expiryDate = expiryDate;
        this.totalPrice = totalPrice;
        this.price = price;
        this.ticketType = ticketType;
        this.car = car;
        this.employee = employee;
        this.location = location;
        this.isDeleted = isDeleted;
    }
    @ManyToOne
    @JoinColumn(name = "ticket_type_id", referencedColumnName = "id")
    private TicketType ticketType;

    @ManyToOne
    @JoinColumn(name = "car_id", referencedColumnName = "id")
    private Car car;

    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "location_id", referencedColumnName = "id")
    private Location location;

    private boolean isDeleted;
    @Column(nullable = false)

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public Ticket() {
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
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

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

}
