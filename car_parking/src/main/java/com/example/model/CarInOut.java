package com.example.model;

import javax.persistence.*;

@Entity
public class CarInOut {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "date", length = 45)
    private String timeIn;

    @Column(columnDefinition = "date", length = 45)
    private String timeOut;

<<<<<<< HEAD
=======
    private String urlCarInImage;

    private String urlCarOutImage;


    public String getUrlCarInImage() {
        return urlCarInImage;
    }


    public void setUrlCarInImage(String originalImageName) {
        this.urlCarInImage = originalImageName;
    }



>>>>>>> origin/car-in-out
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
