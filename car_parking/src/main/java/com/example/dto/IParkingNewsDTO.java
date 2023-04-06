package com.example.dto;

import java.time.LocalDate;

public interface IParkingNewsDTO {
    Integer getParkingNewsId();
    String getTitle();
    String getDescription();
    String getImageUrl();
    String getContent();
    LocalDate getPostingDate();

}

