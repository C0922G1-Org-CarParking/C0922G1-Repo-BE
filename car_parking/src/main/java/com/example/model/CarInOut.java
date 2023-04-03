package com.example.model;

import javax.persistence.*;

@Entity
public class CarInOut {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "varchar(45)")
    private String timeIn;

    @Column(columnDefinition = "varchar(45)")
    private String timeOut;

    private String urlCarInImage;

    private String urlCarOutImage;

    private boolean isParked;

    public String getUrlCarInImage() {
        return urlCarInImage;
    }


    public void setUrlCarInImage(String originalImageName) {
        this.urlCarInImage = originalImageName;
    }


    public boolean isParked() {
        return isParked;
    }

    public void setParked(boolean parked) {
        isParked = parked;
    }

    @ManyToOne
    @JoinColumn(name = "car_id", referencedColumnName = "id")
    private Car car;


    public CarInOut() {
    }

    public String getUrlCarOutImage() {
        return urlCarOutImage;
    }

    public void setUrlCarOutImage(String urlCarInOutImage) {
        this.urlCarOutImage = urlCarInOutImage;
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
