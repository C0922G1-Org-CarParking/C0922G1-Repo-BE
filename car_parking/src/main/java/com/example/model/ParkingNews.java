package com.example.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class ParkingNews {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer parkingNewsId;

    @Column(name = "title", length = 255, nullable = false)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "image_url", nullable = false)
    private String imageUrl;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "posting_date", nullable = false)
    private LocalDate postingDate;

    @Column(name = "is_deleted", columnDefinition = "boolean default 0")
    private boolean isDeleted = false;

    public ParkingNews() {
    }

    public ParkingNews(Integer parkingNewsId, String title, String description, String imageUrl, String content, LocalDate postingDate, Boolean isDeleted) {
        this.parkingNewsId = parkingNewsId;
        this.title = title;
        this.description = description;
        this.imageUrl = imageUrl;
        this.content = content;
        this.postingDate = postingDate;
        this.isDeleted = isDeleted;
    }

    public Integer getParkingNewsId() {
        return parkingNewsId;
    }

    public void setParkingNewsId(Integer parkingNewsId) {
        this.parkingNewsId = parkingNewsId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getPostingDate() {
        return postingDate;
    }

    public void setPostingDate(LocalDate postingDate) {
        this.postingDate = postingDate;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }
}
