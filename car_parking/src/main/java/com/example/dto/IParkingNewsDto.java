package com.example.dto;

import java.time.LocalDate;

public interface IParkingNewsDto {
    Integer getParkingNewsId();
    String getTitle();
    String getDescription();
    String getImageUrl();
    String getContent();
    LocalDate getPostingDate();

}