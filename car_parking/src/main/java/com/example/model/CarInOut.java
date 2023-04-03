package com.example.model;


import javax.persistence.*;


@Entity
public class CarInOut {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    public CarInOut(Long id, String timeIn, String timeOut, Car car) {
        this.id = id;
        this.timeIn = timeIn;
        this.timeOut = timeOut;
        this.car = car;
    }


    @Column(columnDefinition = "date", length = 45)
    private String timeIn;

    @Column(columnDefinition = "date", length = 45)
    private String timeOut;

    @ManyToOne
    @JoinColumn(name = "car_id", referencedColumnName = "id")
    private Car car;


    public CarInOut() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTimeIn() {
        return timeIn;
    }

    public void setTimeIn(String timeIn) {
        this.timeIn = timeIn;
    }

    public String getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(String timeOut) {
        this.timeOut = timeOut;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
